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
	
	
	public static final String LUCENEPATH="LucenePath";
	public static final String XMLPATH="XMLDirectory";
	public static final String MONGDBSERVER="MongoDB_Server";
	public static final String MONGDBCOLLECTION="MongoDB_DB";
	public static final String TARGETPATH="TargetPath";
	
	
	/**
	 * MongoDB_DB=hello
MongoDB_case=true
MongoDB_check=true
MongoDB_clinic=true
MongoDB_disease=true
MongoDB_drug=true
MongoDB_graph=true
MongoDB_operatin=ture
MongoDB_reference=true
MongoDB_route=true
MongoDB_sentences=true
MongoDB_tags=true
MongoDB_videos=ture
	 */
	public static final String CCASE="MongoDB_case";
	public static final String CCHECK="MongoDB_check";
	public static final String CCLINIC="MongoDB_clinic";
	public static final String CDISEASE="MongoDB_disease";
	public static final String CDRUG="MongoDB_drug";
	public static final String CGRAPH="MongoDB_graph";
	public static final String COPERATION="MongoDB_operatin";
	public static final String CREFERENCE="MongoDB_reference";
	
	public static final String CROUTE="MongoDB_route";
	public static final String CSENTENCES="MongoDB_sentences";
	public static final String CTAGS="MongoDB_tags";
	public static final String CVIDEO="MongoDB_videos";
	
	
	//格式文件
	public static final String FORMAT_DOCUMENT="docx";
	public static final String FORMAT_DOCUMENT2="doc";
	public static final String FORMAT_IMAGE="jpg";
	public static final String FORMAT_IMAGE2="png";
	public static final String FORMAT_IMAGE3="bmp";
	public static final String FORMAT_IMAGE4="gif";
	public static final String FORMAT_VIDEO="flv";
	public static final String FORMAT_VIDEO2="rmvb";
	public static final String FORMAT_VIDEO3="mp4";

}
