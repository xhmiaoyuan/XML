package foo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import foo.element.smal.ClassCode;
import foo.element.smal.MateDataRelationSentence;
import foo.element.smal.MetaDataRelationEvidenceItem;
import foo.element.smal.MetaDataRelationFile;
import foo.model.MetaData;
import foo.model.MetaDataForDisease;
import foo.mongoDBModel.Evidence;
import foo.mongoDBModel.Image;
import foo.mongoDBModel.ModelForMongoDB;
import foo.mongoDBModel.Predication;
import foo.mongoDBModel.Route;
import foo.mongoDBModel.Sentence;
import foo.mongoDBModel.Tag;
import foo.mongoDBModel.Video;

public class MetaDataToMongoDBModel {
	private LoadProperty property=new LoadProperty();
	private Map<String,String> mapPath;
	
	MetaDataToMongoDBModel(Map<String,String> mapPath){
		this.mapPath=mapPath;
	}
	
	


	public ModelForMongoDB convertMetaData(MetaData metadata ){
		ModelForMongoDB mode=new ModelForMongoDB();

		if(property.getCollection(ValueClass.CDISEASE)&&metadata.getHeader().getMetaDataID().equals(ValueClass.DISEASE)){
			MetaDataForDisease disease=(MetaDataForDisease)metadata;
			mode.setSubjectumId(disease.getHeader().getIdentifier());
			mode.setName(disease.getDisease().getTitle());
			mode.setPredicateList(addPredicationForDisease(disease));
			List<Tag> taglist=new ArrayList<Tag>();
			Tag tag=new Tag();
			tag.setPredicate("标签");
			tag.setTagList(disease.getDisease().getTag());
			taglist.add(tag);
			mode.setTagList(taglist);
			mode.setImageList(convertImage(metadata));
			mode.setSentenceList(convertSentence(metadata));
			mode.setVideoList(convertVideo(metadata));
			mode.setEvidenceList(convertEvidence(metadata));
			mode.setRouteList(convertRoute(metadata));
		}	
		return mode;
		
	}
	
	
	/**
	 * 给定一个metadata返回句子数组
	 * @param metadata
	 * @return
	 */
	public List<Sentence> convertSentence(MetaData metadata ){
		List<Sentence> sentenceList=new ArrayList<Sentence>();
		for(MateDataRelationSentence metaSen:metadata.getRelation().getSentences()){
		Sentence sentence=new Sentence();
		sentence.setTitle(metaSen.getBookTitle());
		sentence.setContent(metaSen.getText());
		sentence.setEbookpageNum(metaSen.getPage());
		sentence.setObjectid(metaSen.getObjID());
		sentence.setMetaid(metaSen.getMetaID());
		sentence.setPublisher(metaSen.getPublisher());
		//sentence.setRelationnum(metaSen.get);
		sentenceList.add(sentence);
		}
		return sentenceList;
	}
	/**
	 * 给定一个metadata返回
	 * @param metadata
	 * @return
	 */
	public List<Image> convertImage(MetaData metadata){
		List<Image> imageList=new ArrayList<Image>();
		for(MetaDataRelationFile file:metadata.getRelation().getFile()){
			if(file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_IMAGE)||
					file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_IMAGE2)||
							file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_IMAGE3)||
							file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_IMAGE4)){
				 Image image =new Image();
				 image.setImagePath(mapPath.get(file.getFileName()));
				 image.setImageDetail(file.getTechMD().getFileDesc());
				 image.setName(file.getId().getObjID());
				 imageList.add(image);
			}
		}
		return imageList;
		
	}
	public List<Route> convertRoute(MetaData metadata){
		List<Route> routeList=new ArrayList<Route>();
		for(MetaDataRelationFile file:metadata.getRelation().getFile()){
			if(file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_DOCUMENT)||
					file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_DOCUMENT2)){
				 Route route =new Route();
				 route.setName(file.getId().getObjID());
				 route.setPath(mapPath.get(file.getFileName()));
				 route.setValue(file.getTechMD().getFileDesc());
				 routeList.add(route);
			}
		}
		
		return routeList;
		
	}
	
	public List<Video> convertVideo(MetaData metadata){
		List<Video> videoList=new ArrayList<Video>();
		for(MetaDataRelationFile file:metadata.getRelation().getFile()){
			if(file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_VIDEO)||
					file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_VIDEO2)||
							file.getTechMD().getFormat().equalsIgnoreCase(ValueClass.FORMAT_VIDEO3)){
				 Video video =new Video();
				 video.setName(file.getId().getObjID());
				 video.setDescription(file.getTechMD().getFileDesc());
				 video.setPath(mapPath.get(file.getFileName()));
				// video.setPicturepath(mapPath.get(file.getFileName()));
				 videoList.add(video);

			}
		}
		return videoList;
	}
	
	public List<Evidence> convertEvidence(MetaData metadata){
		List<Evidence> evidenceList=new ArrayList<Evidence>();
		for(MetaDataRelationEvidenceItem evi:metadata.getRelation().getEvidenceItems()){
			Evidence evidence=new Evidence();
			evidence.setContent(evi.getContext());
			evidence.setCreateor(evi.getCreator());
			evidence.setSource(evi.getSource());
			evidence.setURL(evi.getUrl());
			evidence.setTitle(evi.getTitle());
			evidenceList.add(evidence);

		}
		return evidenceList;
		
	}
	
	
	
	
	private List<Predication> addPredicationForDisease(MetaDataForDisease disease){
		List<Predication> listpredication=new ArrayList<Predication>();
		if(disease.getDisease().getCause()!=null){
			Predication pre1=new Predication();
			pre1.setPredicateName("病因与发病机制");
			List<String> str=new ArrayList<String>();
			str.add(disease.getDisease().getCause());
			pre1.setObjectsList(str);	
			listpredication.add(pre1);
		}
		 if(disease.getDisease().getSymptom()!=null){
			Predication pre1=new Predication();
			pre1.setPredicateName("临床表现");
			List<String> str=new ArrayList<String>();
			str.add(disease.getDisease().getSymptom());
			pre1.setObjectsList(str);	
			listpredication.add(pre1);			
		} if(disease.getDisease().getDisagnosis()!=null){
			Predication pre1=new Predication();
			pre1.setPredicateName("诊断与鉴别诊断");
			List<String> str=new ArrayList<String>();
			str.add(disease.getDisease().getDisagnosis());
			pre1.setObjectsList(str);	
			listpredication.add(pre1);			
		} if(disease.getDisease().getTherapy()!=null){
			Predication pre1=new Predication();
			pre1.setPredicateName("治疗");
			List<String> str=new ArrayList<String>();
			str.add(disease.getDisease().getTherapy());
			pre1.setObjectsList(str);	
			listpredication.add(pre1);			
		} if(disease.getDisease().getPrevention()!=null){
			Predication pre1=new Predication();
			pre1.setPredicateName("预防");
			List<String> str=new ArrayList<String>();
			str.add(disease.getDisease().getPrevention());
			pre1.setObjectsList(str);	
			listpredication.add(pre1);			
		} if(disease.getDisease().getPrognosis()!=null){
			Predication pre1=new Predication();
			pre1.setPredicateName("预后");
			List<String> str=new ArrayList<String>();
			str.add(disease.getDisease().getPrognosis());
			pre1.setObjectsList(str);	
			listpredication.add(pre1);			
		} if(disease.getDisease().getAbstract()!=null){
			Predication pre1=new Predication();
			pre1.setPredicateName("定义及概述");
			List<String> str=new ArrayList<String>();
			str.add(disease.getDisease().getAbstract());
			pre1.setObjectsList(str);	
			listpredication.add(pre1);			
		}
		 if(disease.getDisease().getClassCode()!=null){			
		
			for(ClassCode classcode:disease.getDisease().getClassCode()){
				Predication pre1=new Predication();
				pre1.setPredicateName(classcode.getType());
				List<String> str=new ArrayList<String>();
				str.add(classcode.getText());
				pre1.setObjectsList(str);	
				listpredication.add(pre1);				
			}			
		}
		return listpredication;		
	}
	public static void main(String[] args) {
		
	}
	
}
