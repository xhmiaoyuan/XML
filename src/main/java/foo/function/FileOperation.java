package foo.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {


	public void pastFile(List<String> fileList,String nameIdentifier,String Goal){
		String letter1=GetFirstLetter.getFirstLetter(nameIdentifier);
		String letter2=GetFirstLetter.getFirstLetter(nameIdentifier.substring(1, nameIdentifier.length()-1));
		
		for(String filep:fileList){
			String originFile=filep;
			String goalFile=Goal+'\\'+letter1+'\\'+letter2+'\\'+nameIdentifier+'\\'+filep.substring(filep.lastIndexOf("\\"),filep.length());
			File goalFileDirectory=new File(Goal+'\\'+letter1+'\\'+letter2+'\\'+nameIdentifier);
			if(!goalFileDirectory.exists()){
				goalFileDirectory.mkdirs();
			}
			
			copy(originFile,goalFile);
			
		}
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
				/*
				 * 递归调用
				 */
				this.getFiles(file.getAbsolutePath(),flge);
				System.out.println("显示" + filePath + "下所有子目录及其文件"
						+ file.getAbsolutePath());
			} else {
				if (file.getName().contains(flge)) {
					fileList.add(file.getAbsolutePath());
					System.out.println("显示" + filePath + "下所有子目录及其文件"
							+ file.getAbsolutePath());
				}
				System.out.println("显示" + filePath + "下所有子目录"
						+ file.getAbsolutePath());
			}
		}
		return fileList;
	}
	
	
	
	public static void main(String[] args) {
		
		
		String filePath="E:\\BaiduYunDownload\\work2\\demo";
		String targetPath="F:\\target";
		String diseases="克罗恩病NNKMNmDM";
		FileOperation file=new FileOperation();
		file.pastFile(file.getFiles(filePath,".xml"), diseases, targetPath);		
	}
	
}
