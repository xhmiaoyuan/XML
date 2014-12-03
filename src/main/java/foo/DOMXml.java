package foo;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import foo.element.big.MetaDataAdminMD;
import foo.element.big.MetaDataDisease;
import foo.element.big.MetaDataForAll;
import foo.element.big.MetaDataHeader;
import foo.element.big.MetaDataRelations;
import foo.element.smal.ClassCode;
import foo.element.smal.MateDataRelationSentence;
import foo.element.smal.MetaDataEvidenceCopyRightDesc;
import foo.element.smal.MetaDataRelationEvidenceItem;
import foo.element.smal.MetaDataRelationFile;
import foo.element.smal.MetaDataRelationKnowledge;
import foo.function.FileOperation;
import foo.model.MetaData;
import foo.model.MetaDataForCase;
import foo.model.MetaDataForDisease;
import foo.mongoDBModel.ModelForMongoDB;

public class DOMXml {

	
	public DOMXml(){
		
	}
	
	
	public static void main(String[] args) throws Exception {
		DOMXml domxml = new DOMXml();
		List<MetaData> listMetaData=new ArrayList<MetaData>();
		String pathDirectory="E:\\BaiduYunDownload\\work2\\demo";
		listMetaData =domxml.processXML(pathDirectory);
		for(MetaData meta:listMetaData){
			List<String> listString=domxml.getFilePath(meta);
			FileOperation fileOperation=new FileOperation();
			if(meta.getHeader().getMetaDataID().equals(ValueClass.DISEASE)){
				MetaDataForDisease me=(MetaDataForDisease) meta;
				PushDataToSolr solr=new PushDataToSolr("E:\\solr_home\\collection1\\data\\index");
				solr.convertDataToSolr(me);

				MetaDataToMongoDBModel metadata=new MetaDataToMongoDBModel();
				ModelForMongoDB mongDBModel=metadata.convertMetaData(me);
				PushDataToMongoDB mongoDB=new PushDataToMongoDB();

				mongoDB.insertData(mongDBModel);
//				
				fileOperation.pastFile(listString,me.getDisease().getTitle()+me.getHeader().getIdentifier(), "F:\\");
			}
			
		}

	}
	
	
	
	public List<MetaData> processXML(String pathDirectory){
		List<MetaData> listMetaData2=new ArrayList<MetaData>();
		FileOperation fileOperation=new FileOperation();
		String flge=".xml";
		List<String> listfile=fileOperation.getFiles(pathDirectory, flge);
		for(String str:listfile){
			MetaData metadata=initial(str);	
			listMetaData2.add(metadata);			
		}
		return listMetaData2;
		
	}
	
	
	private List<String> getFilePath(MetaData metadata){
		List<MetaDataRelationFile> filePaths=metadata.getRelation().getFile();
		List<String> listString=new ArrayList<String>();
		for(MetaDataRelationFile f:filePaths){
			listString.add(ValueClass.ABSOLUTIPATH+"\\"+f.getFileName());
		}
		return listString; 
		
		
	}

	private MetaData initial(String xmlpath) {
		SAXReader reader = new SAXReader();
		MetaData metadata = null;
		try {
			Document document = reader.read(new File(xmlpath));
			Element root = document.getRootElement();
			
				metadata=createCase(root);
		
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return metadata;
	}

	private MetaData createCase(Element root) throws Exception {
		List<Element> nodes = root.elements();

		MetaData metadata = null;
		MetaDataHeader mdh = null;
		MetaDataForAll metaDataForall = null;
		MetaDataRelations relation = null;
		MetaDataAdminMD adminMD = null;
		String type = null;
		for (Element child : nodes) {
			if (child.getName().equals(ValueClass.HEADER)) {
				 mdh = addXMLHeader(child);
				System.out.println(mdh.getMetaDataID());
				type = mdh.getMetaDataID();
			} else if (child.getName().equals(ValueClass.METADATA)) {
				if (type.equals(ValueClass.DISEASE)) {
					metadata = new MetaDataForDisease();
					metaDataForall = new MetaDataDisease();
					addXMLMetaDaraForAll(metaDataForall,child);
					addXMLMetaDataDisease((MetaDataDisease)metaDataForall,child);
				}
				else if(child.getName().equals(ValueClass.OPERATION)){
					//metadata =new MetaDataForOperation();
					
					
				}
			} else if (child.getName().equals(ValueClass.REALATIONS)) {
				relation=addXMLRelation(child);
			} else if (child.getName().equals(ValueClass.ADMINMD)) {
				adminMD=addXMLAdminMD(child);
			}
			System.out.println(child.getName());
		}
		if(type.equals("am_disease")){
			MetaDataForDisease disease=(MetaDataForDisease)metadata;
			disease.setAdminMD(adminMD);
			disease.setDisease((MetaDataDisease)metaDataForall);
			disease.setHeader(mdh);
			disease.setRelation(relation);
			return disease;
		}
		else if(type.equals("am_case")){
			
		}

		return null;
	}

	private void addXMLMetaDaraForAll(MetaDataForAll metadataForAll,Element e) {
		List<Element> elements = e.elements();
		for (Element el : elements) {
			if (el.getName().equals("Title")) {
				metadataForAll.setTitle(el.getText());
			} else if (el.getName().equals("Abstract")) {
				metadataForAll.setAbstract(el.getText());
			} else if (el.getName().equals("Synonym")) {
				metadataForAll.getSynonyms().add(el.getText());
			} else if (el.getName().equals("ClassCode")) {
				ClassCode classCode = new ClassCode();
				classCode.setType(el.attributeValue("Type"));
				classCode.setText(el.getText());
				metadataForAll.getClassCode().add(classCode);
			} else if (el.getName().equals("Tag")) {
				metadataForAll.getTag().add(el.getText());
			}
		}
		
	}

	private MetaDataAdminMD addXMLAdminMD(Element child) {
		MetaDataAdminMD adminMD = new MetaDataAdminMD();
		List<Element> listelem = child.elements();
		for (Element ele : listelem) {

			System.out.println(ele.getName());
			if (ele.getName().equals("CopyRightsDesc")) {
				MetaDataEvidenceCopyRightDesc copy = new MetaDataEvidenceCopyRightDesc();
				copy.setContext(ele.getText());
				copy.setCopyRightID(ele.attributeValue("CopyRightOwnerID"));
				copy.setURL(ele.attributeValue("URL"));
				adminMD.setCopyRightOwnerID(copy);
			} else if (ele.getName().equals("Source")) {
				adminMD.setSource(ele.getText());
			} else if (ele.getName().equals("EditorVersion")) {
				adminMD.setEditorVersion(Integer.parseInt(ele.getText()));
			}

		}
		System.out.println(adminMD.toString());
		return adminMD;

	}

	private MetaDataRelations addXMLRelation(Element child) {

		MetaDataRelations relation = new MetaDataRelations();

		List<Element> childs = child.elements();
		for (Element e : childs) {
			if (e.getName().equals("Knowledges")) {

				List<Element> strs = e.elements();
				for (Element el : strs) {
					MetaDataRelationKnowledge knowledge = new MetaDataRelationKnowledge();
					knowledge.setContext(el.getText());
					knowledge.setRelevance(el.attributeValue("relevance"));
					knowledge.setID(el.attributeValue("ID"));
					knowledge.setType(el.attributeValue("type"));
					relation.getKnowledges().add(knowledge);
				}
			}

			else if (e.getName().equals("fileSec")) {

				List<Element> strs = e.elements();
				for (Element el : strs) {
					MetaDataRelationFile file = new MetaDataRelationFile();
					file.setOrder(Integer.parseInt(el.attributeValue("Order")));
					file.setFileDesc(el.attributeValue("FileDesc"));
					file.setFilePath(el.attributeValue("FilePath"));
					file.setFileName(el.attributeValue("FileName"));
					List<Element> listid = el.elements();
					for (Element ele : listid) {
						if (ele.getName().equals("id")) {
							file.getId().setObjID(ele.elementText("ObjID"));
							file.getId().setPObjID( ele.elementText("PObjID"));
						} else if (ele.getName().equals("techMD")) {
							file.getTechMD().setEncryptInfo(Integer.parseInt(ele
									.elementText("EncryptInfo")));
							file.getTechMD().setFileDesc(ele.elementText("FileDesc"));
							file.getTechMD().setFileNotes(ele
									.elementText("FileNotes"));
							file.getTechMD().setFileSize(ele.elementText("FileSize"));
							file.getTechMD().setFileTitle(ele
									.elementText("FileTitle"));
							file.getTechMD().setFormat(ele.elementText("Format"));
							file.getTechMD().setHeight(Long.parseLong((String) (ele
									.elementText("Heigth").equals("") ? "0"
									: ele.elementText("Heigth"))));
							file.getTechMD().setHeight(Long.parseLong((String) (ele
									.elementText("Width").equals("") ? "0"
									: ele.elementText("Width"))));
							file.getTechMD().setObjType(ele.elementText("ObjType"));
						}

					}
					relation.getFile().add(file);
				}

			} else if (e.getName().equals("Sentences")) {
				List<Element> liste = e.elements();
				for (Element el : liste) {
					MateDataRelationSentence sentence = new MateDataRelationSentence();
					List<Element> listelem = el.elements();
					for (Element ele : listelem) {
						if (ele.getName().equals("BookTitle")) {
							sentence.setBookTitle(ele.getText());
						} else if (ele.getName().equals("MetaID")) {
							sentence.setMetaID(ele.getText());
						} else if (ele.getName().equals("ObjID")) {
							sentence.setObjID(ele.getText());
						} else if (ele.getName().equals("STag")) {
							sentence.getTags().add(ele.getText());
						} else if (ele.getName().equals("Page")) {
							sentence.setPage(Integer.parseInt(ele.getText()));
						} else if (ele.getName().equals("SentenceClass")) {
							sentence.setSentenceClass(ele.getText());
						} else if (ele.getName().equals("Text")) {
							sentence.setText(ele.getText());
						} else {
							System.out.println("UNKNOW TYPE:" + ele.getName());
						}

					}

					relation.getSentences().add(sentence);
				}

			} else if (e.getName().equals("Evidences")) {
				List<Element> listele = e.elements();
				for (Element el : listele) {
					MetaDataRelationEvidenceItem evidenceitem = new MetaDataRelationEvidenceItem();
					evidenceitem.setCreator(el.attributeValue("creator"));
					evidenceitem.setSource(el.attributeValue("source"));
					evidenceitem.setUrl(el.attributeValue("url"));
					evidenceitem.setEabstract(el.attributeValue("eabstract"));
					evidenceitem.setContext(el.getText());
					relation.getEvidenceItems().add(evidenceitem);
				}
			}

		}
		System.out.println(relation.toString());
		return relation;

	}

	private MetaDataHeader addXMLHeader(Element e) throws ParseException {
		MetaDataHeader header = new MetaDataHeader();
		header.setIdentifier(e.elementText("identifier"));
		header.setComplexOID(e.elementText("complexOID"));
		header.setCreateDate(ValueClass.ISO8601_DATE_FORMAT.parse(e
				.elementText("createdDate")));
		header.setLastModifiedDate(ValueClass.ISO8601_DATE_FORMAT.parse(e
				.elementText("lastModifiedDate")));
		Element metaType = e.element("metadataType");
		header.setMetaDataID(metaType.attributeValue("ID"));
		header.setMetaDataVersion(metaType.attributeValue("Version"));
		Element IDtype = e.element("identifier");
		header.setIdentifierIDType(IDtype.attributeValue("IDType"));
		System.out.println(header.toString());
		return header;

	}
	

	private MetaDataDisease addXMLMetaDataDisease(MetaDataDisease metaDisease, Element e) {
		List<Element> elements = e.elements();
		for (Element el : elements) {
			if (el.getName().equals("Cause")) {
				metaDisease.setCause(el.getText());
			} else if (el.getName().equals("Symptom")) {
				metaDisease.setSymptom(el.getText());
			} else if (el.getName().equals("Therapy")) {
				metaDisease.setTherapy(el.getText());
			} else if (el.getName().equals("Diagnosis")) {
				metaDisease.setDisagnosis(el.getText());
			} else if (el.getName().equals("Prevention")) {
				metaDisease.setPrevention(el.getText());
			} else if (el.getName().equals("Prognosis")) {
				metaDisease.setPrognosis(el.getText());
			} else if (el.getName().equals("Notes")) {
				metaDisease.getNotes().add(el.getText());
			} else {
				System.out.println("UNKNOW TYPE:" + el.getName());
			}
		}
		System.out.println(metaDisease.toString());
		return metaDisease;
	}
}