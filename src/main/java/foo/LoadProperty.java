package foo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class LoadProperty {
	private static Properties props = new Properties();

	public  String GetP(String value) {

		try {
			// 资源文件存放在类文件的根目录下。即是放在src下面。
			props.load(getClass().getClassLoader().getResourceAsStream(
					"config.properties"));
			// 当资源文件中有中文的时候可以采用下面的编码转化方法来读取。
			// 或者使用native2ascii jin1.properties或者jin1.txt
			// jin.properties将资源文件进行编码转化，
			// 然后直接读取props.getProperty("name");

			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return props.getProperty(value);

	}
	
	public boolean getCollection(String str){
		if(GetP(str).equals("true")){
				return true;
		}
		else{
			return false;
			
		}
	}

	public static void main(String[] args) {
		LoadProperty a = new LoadProperty();
		a.GetP("LucenePath");

	}

}
