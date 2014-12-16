package foo.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import foo.LoadProperty;
import foo.ValueClass;
import foo.element.smal.MetaDataRelationFile;
import foo.model.MetaData;
import foo.model.MetaDataForCase;
import foo.model.MetaDataForDisease;
import foo.model.MetaDataForDrug;
import foo.model.MetaDataForExamination;
import foo.model.MetaDataForOperation;

public class FileOperation {

	private LoadProperty properties=new LoadProperty();

	public Map<String,String> pastFile(List<String> fileList,String nameIdentifier){
		LoadProperty properties=new LoadProperty();
		String Goal=properties.GetP(ValueClass.TARGETPATH);
		System.out.println(nameIdentifier);
		String letter1=GetFirstLetter.getFirstLetter(nameIdentifier.charAt(0)).toString();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calendar=Calendar.getInstance();
		String data=sdf.format(calendar.getTime());
		Map<String,String> mapPath=new HashMap<String,String>();
		for(String filep:fileList){
			String originFile=filep;
			String name=filep.substring(filep.lastIndexOf("\\"),filep.length());
			String goalFile=Goal+'\\'+data+'\\'+letter1+'\\'+nameIdentifier+name;
			File goalFileDirectory=new File(Goal+'\\'+data+'\\'+letter1+'\\'+nameIdentifier);
			if(!goalFileDirectory.exists()){
				goalFileDirectory.mkdirs();
			}
			mapPath.put(name.substring(1,name.length()), goalFile);
			
			copy(originFile,goalFile);
			
		}
		return mapPath;
	}
	
	public Map<String,String> MoveFile(MetaData metadata){
		List<String> listString=getFilePath(metadata);
		String name=null;
		if(metadata.getHeader().getMetaDataID().equals(ValueClass.DISEASE)){
			MetaDataForDisease disease=(MetaDataForDisease)metadata;
			 name=disease.getDisease().getTitle() +disease.getHeader().getIdentifier();				
		}else if(metadata.getHeader().getMetaDataID().equals(ValueClass.CASE)){
			MetaDataForCase diseasecase=(MetaDataForCase) metadata;
			name=diseasecase.getDiseasecase().getTitle()+diseasecase.getHeader().getIdentifier();
		}else if(metadata.getHeader().getMetaDataID().equals(ValueClass.DRUG)){
			MetaDataForDrug drug=(MetaDataForDrug)metadata;
			name=drug.getDrug().getTitle()+drug.getHeader().getIdentifier();
		}else if(metadata.getHeader().getMetaDataID().equals(ValueClass.EXAMINATION)){
			MetaDataForExamination examination=(MetaDataForExamination) metadata;
			name=examination.getExamination().getTitle()+examination.getHeader().getIdentifier();
		}else if(metadata.getHeader().getMetaDataID().equals(ValueClass.OPERATION)){
			MetaDataForOperation operation=(MetaDataForOperation) metadata;
			name=operation.getOperation().getTitle()+operation.getHeader().getIdentifier();
		}
		return pastFile(listString,name);
	
	}
	
	
	
	private List<String> getFilePath(MetaData metadata){
		System.out.println("获得xml文件图片地址");
		List<MetaDataRelationFile> filePaths=metadata.getRelation().getFile();
		List<String> listString=new ArrayList<String>();
		for(MetaDataRelationFile f:filePaths){
			listString.add(properties.GetP(ValueClass.XMLPATH)+"\\"+f.getFileName());
		}
		return listString; 
		
		
	}
	
    private void copy(String from, String to) {   
        try {   
             InputStream in = new FileInputStream(from);   
             OutputStream out = new FileOutputStream(to);   
   
            byte[] buff = new byte[1024];   
            int len = 0;   
            while ((len = in.read(buff)) != -1) {   
                 out.write(buff, 0, len);   
             }   
             in.close();   
             out.close();   
         } catch (FileNotFoundException e) {   
             e.printStackTrace();   
         } catch (IOException e) {   
             e.printStackTrace();   
         }   
     } 
    /**
     * 得到指定目录下包含有flge标记的的文件夹列表
     * @param filePath
     * @param flge
     * @return
     */
	public List<String> getFiles(String filePath,String flge) {
		List<String> fileList=new ArrayList<String>();
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {			
			if (file.isDirectory()) {
				this.getFiles(file.getAbsolutePath(),flge);
			} else {
				if (file.getName().endsWith(flge)) {
					fileList.add(file.getAbsolutePath());
				}

			}
		}
		return fileList;
	}
	
	
	
	public static void main(String[] args) {
		
		
		String filePath="E:\\BaiduYunDownload\\work2\\demo";
		String diseases="克罗恩病NNKMNmDM";
		FileOperation file=new FileOperation();
		file.pastFile(file.getFiles(filePath,".xml"), diseases);		
	}
	
}
