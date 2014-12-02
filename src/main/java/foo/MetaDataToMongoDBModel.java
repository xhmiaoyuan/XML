package foo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mongodb.BasicDBObject;

import foo.element.smal.ClassCode;
import foo.model.MetaData;
import foo.model.MetaDataForCase;
import foo.model.MetaDataForDisease;
import foo.mongoDBModel.ModelForMongoDB;
import foo.mongoDBModel.Predication;

public class MetaDataToMongoDBModel {

	
	public ModelForMongoDB convertMetaData(MetaData metadata ){
		ModelForMongoDB mode=new ModelForMongoDB();
		if(metadata.getHeader().getMetaDataID().equals(ValueClass.DISEASE)){
			MetaDataForDisease disease=(MetaDataForDisease)metadata;
			mode.setSubjectumId(disease.getHeader().getIdentifier());
			mode.setName(disease.getDisease().getEnTitle());
			mode.setPredicateList(addPredicationForDisease(disease));
		}
		
		
		return mode;
		
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
		JSONArray jsonArray = JSONArray.fromObject(listpredication); 
		System.out.println(jsonArray);
		return listpredication;
		
	}
	public static void main(String[] args) {
		
	}
	
}
