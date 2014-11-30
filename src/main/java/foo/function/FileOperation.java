package foo.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class FileOperation {

	String pathForOrigin="";
	String pathForGoal="";
	
	public void pastFile(List<String> fileList,String nameIdentifier,String Goal,String origin){
		String letter1=GetFirstLetter.getFirstLetter(nameIdentifier);
		String letter2=GetFirstLetter.getFirstLetter(nameIdentifier.substring(1, nameIdentifier.length()-1));
		
		for(String filep:fileList){
			String originFile=origin+'\\'+filep;
			String goalFile=Goal+'\\'+letter1+'\\'+letter2+'\\'+nameIdentifier+'\\'+filep;
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
	
	
}
