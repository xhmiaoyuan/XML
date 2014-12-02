package foo;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import foo.model.MetaData;

public class ValueClass {
	public static final String DISEASE="am_disease";
	public static final String CASE="am_case";
	public static final String SYMPTOM="am_symptom";
	public static final String OPERATION="am_operation";
	public static final String EXAMINATION="am_examination";
	public static final String DRUG="am_drug";
	
	
	
	
	public static final String ROOT = "medicine";
	public static final String HEADER = "header";
	public static final String METADATA = "metadata";
	public static final String REALATIONS = "Relations";
	public static final String ADMINMD = "adminMD";
	public static final DateFormat ISO8601_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");
	// private File filexml= new
	// File("C:\\Users\\my\\Desktop\\work2\\疾病标准样例.xml");
	public static final File filexml = new File("E:\\BaiduYunDownload\\work2\\疾病标准样例.xml");
	public static final List<String> listfile=new ArrayList<String>();
	public static final List<MetaData> MetaDatas=new ArrayList();
	public static final String ABSOLUTIPATH ="E:\\BaiduYunDownload\\work2\\demo"; 

}
