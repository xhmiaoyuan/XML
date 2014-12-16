package foo;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzerWithSmart;









import foo.PinYin.Hanyu;
import foo.element.smal.ClassCode;
import foo.model.MetaData;
import foo.model.MetaDataForCase;
import foo.model.MetaDataForDisease;
import foo.model.MetaDataForDrug;
import foo.model.MetaDataForExamination;
import foo.model.MetaDataForOperation;
import foo.mongoDBModel.Tag;

public class PushDataToSolr {
	Directory indexDir;
	IndexWriter indexWriter;
	Analyzer luceneAnalyzer;
	IKAnalyzerWithSmart ikAnalyzer=null;

	public PushDataToSolr(String DBpath) {
		File fileIndex = new File(DBpath);

		try {
			indexDir = FSDirectory.open(fileIndex);

			luceneAnalyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
			ikAnalyzer=new IKAnalyzerWithSmart(true);
			String filePath = PushDataToSolr.class.getResource("").getPath();
			filePath = filePath.substring(0, filePath.indexOf("classes") + 7);
			// "E:\\eclipseWorlk\\Java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\founder.medical\\WEB-INF\\classes"
			
			ikAnalyzer.setConfigFilePath(filePath);

			indexWriter = new IndexWriter(indexDir, new IndexWriterConfig(
					Version.LUCENE_CURRENT, ikAnalyzer));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void convertDataToSolr(MetaData metadata) throws IOException {
		PinYin pinyin = new PinYin();
		Hanyu hanyu = pinyin.getHanyu();
		QueryParser parser = new QueryParser(Version.LUCENE_CURRENT,
				"ID", ikAnalyzer);
		Query query = null;
		//"ID": "NNKMNmDM"
		try {
			 query = parser.parse(metadata.getHeader().getIdentifier());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		indexWriter.deleteDocuments(query);
		indexWriter.forceMergeDeletes();
		indexWriter.commit();

		if (metadata.getHeader().getMetaDataID().equals(ValueClass.DISEASE)) {
			MetaDataForDisease disease = (MetaDataForDisease) metadata;
			Document document = new Document();
			document.add(new IntField("Type", 1, Field.Store.YES));
			if (disease.getDisease().getTitle() != null) {
				String title = disease.getDisease().getTitle();
				document.add(new Field("Name", title, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));
				String pin = hanyu.getStringPinYin(title).toLowerCase();
				String initial = pin.substring(0, 1).toUpperCase();
				document.add(new Field("Initial", initial, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));
				document.add(new Field("Spell", pin, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));

			}
			for (ClassCode classCode : disease.getDisease().getClassCode()) {
				if (classCode.getType().equals("ICD10分类")) {
					document.add(new Field("Class", classCode.getText(),
							Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));
				}else if(classCode.getType().equals("body")){
					document.add(new Field("Position",classCode.getText(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				}else if(classCode.getType().equals("department")){
					document.add(new Field("Department",classCode.getText(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				}
			}
			if (disease.getHeader().getIdentifier() != null) {
				document.add(new Field("ID", disease.getHeader()
						.getIdentifier(), Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));
			}
			if (disease.getDisease().getAbstract() != null) {
				document.add(new Field("Abstract", disease.getDisease()
						.getAbstract(), Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.YES));
			}
			if(disease.getDisease().getTag()!=null){
				StringBuilder strbuilder=new StringBuilder();
				for(String tag:disease.getDisease().getTag()){
					strbuilder.append(tag);
					}
				document.add(new Field("Tags",strbuilder.toString(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			indexWriter.addDocument(document);

		}
		else if(metadata.getHeader().getIdentifierIDType().equals(ValueClass.SYMPTOM)){
			MetaDataForCase diseasecase=(MetaDataForCase)metadata;
			Document document=new Document();
			document.add(new IntField("Type",2,Field.Store.YES));
			if(diseasecase.getDiseasecase().getTitle()!=null){
				String title=diseasecase.getDiseasecase().getTitle();
				document.add(new Field("Name",title,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				String pin=hanyu.getStringPinYin(title).toLowerCase();
				String Initial=pin.substring(0, 1).toUpperCase();
				document.add(new Field("Initial",Initial,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				document.add(new Field("Spell",pin,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				
			}
			for(ClassCode classCode:diseasecase.getDiseasecase().getClassCode()){
				if(classCode.getType().equals("科室")){
					document.add(new Field("Class",classCode.getText(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
					
				}
				if(classCode.getType().equals("部位")){
					document.add(new Field("Position",classCode.getText(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				}
			}
			if(diseasecase.getHeader().getIdentifier()!=null){
				document.add(new Field("Abstract",diseasecase.getDiseasecase().getAbstract(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			if(diseasecase.getHeader().getIdentifier()!=null){
				document.add(new Field("ID",diseasecase.getHeader().getIdentifier(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			if(diseasecase.getDiseasecase().getTag()!=null){
				StringBuilder strbuilder=new StringBuilder();
				for(String tag:diseasecase.getDiseasecase().getTag()){
					strbuilder.append(tag);
					}
				document.add(new Field("Tags",strbuilder.toString(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			indexWriter.addDocument(document);
		}
		
		
		else if(metadata.getHeader().getIdentifierIDType().equals(ValueClass.EXAMINATION)){
			MetaDataForExamination examination =(MetaDataForExamination) metadata;
			Document document=new Document();
			document.add(new IntField("Type",3,Field.Store.YES));
			if(examination.getExamination().getTitle()!=null){
				String title=examination.getExamination().getTitle();
				document.add(new Field("Name",title,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				String pin=hanyu.getStringPinYin(title).toLowerCase();
				String Initial=pin.substring(0, 1).toUpperCase();
				document.add(new Field("Initial",Initial,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				document.add(new Field("Spell",pin,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				
			}
			for(ClassCode classCode:examination.getExamination().getClassCode()){
				
				//要改
				if(classCode.getType().equals("分类")){
					document.add(new Field("Class",classCode.getText(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
					
				}
			}
			if(examination.getHeader().getIdentifier()!=null){
				document.add(new Field("Abstract",examination.getExamination().getAbstract(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			if(examination.getHeader().getIdentifier()!=null){
				document.add(new Field("ID",examination.getHeader().getIdentifier(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			if(examination.getExamination().getTag()!=null){
				StringBuilder strbuilder=new StringBuilder();
				for(String tag:examination.getExamination().getTag()){
					strbuilder.append(tag);
					}
				document.add(new Field("Tags",strbuilder.toString(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			indexWriter.addDocument(document);
		}
		else if(metadata.getHeader().getIdentifierIDType().equals(ValueClass.DRUG)){
			MetaDataForDrug drug =(MetaDataForDrug) metadata;
			Document document=new Document();
			document.add(new IntField("Type",4,Field.Store.YES));
			if(drug.getDrug().getTitle()!=null){
				String title=drug.getDrug().getTitle();
				document.add(new Field("Name",title,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				String pin=hanyu.getStringPinYin(title).toLowerCase();
				String Initial=pin.substring(0, 1).toUpperCase();
				document.add(new Field("Initial",Initial,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				document.add(new Field("Spell",pin,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				
			}
			for(ClassCode classCode:drug.getDrug().getClassCode()){
				
				//要改
				if(classCode.getType().equals("分类")){
					document.add(new Field("Class",classCode.getText(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
					
				}
			}
			if(drug.getHeader().getIdentifier()!=null){
				document.add(new Field("Abstract",drug.getDrug().getAbstract(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			if(drug.getHeader().getIdentifier()!=null){
				document.add(new Field("ID",drug.getHeader().getIdentifier(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			if(drug.getDrug().getTag()!=null){
				StringBuilder strbuilder=new StringBuilder();
				for(String tag:drug.getDrug().getTag()){
					strbuilder.append(tag);
					}
				document.add(new Field("Tags",strbuilder.toString(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			indexWriter.addDocument(document);
		}
		else if(metadata.getHeader().getIdentifierIDType().equals(ValueClass.OPERATION)){
			MetaDataForOperation operation =(MetaDataForOperation) metadata;
			Document document=new Document();
			document.add(new IntField("Type",5,Field.Store.YES));
			if(operation.getOperation().getTitle()!=null){
				String title=operation.getOperation().getTitle();
				document.add(new Field("Name",title,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				String pin=hanyu.getStringPinYin(title).toLowerCase();
				String Initial=pin.substring(0, 1).toUpperCase();
				document.add(new Field("Initial",Initial,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				document.add(new Field("Spell",pin,Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
				
			}
			for(ClassCode classCode:operation.getOperation().getClassCode()){
				
				//要改
				if(classCode.getType().equals("分类")){
					document.add(new Field("Class",classCode.getText(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
					
				}
			}
			if(operation.getHeader().getIdentifier()!=null){
				document.add(new Field("Abstract",operation.getOperation().getAbstract(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			if(operation.getHeader().getIdentifier()!=null){
				document.add(new Field("ID",operation.getHeader().getIdentifier(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			if(operation.getOperation().getTag()!=null){
				StringBuilder strbuilder=new StringBuilder();
				for(String tag:operation.getOperation().getTag()){
					strbuilder.append(tag);
					}
				document.add(new Field("Tags",strbuilder.toString(),Field.Store.YES,Field.Index.ANALYZED,Field.TermVector.YES));
			}
			indexWriter.addDocument(document);
		}

		
		//System.out.println("是否有删除="+indexWriter.hasDeletions());
	}
	
	public void closeSolr() throws IOException{
		indexWriter.close();
	}
}
