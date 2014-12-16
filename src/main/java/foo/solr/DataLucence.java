package foo.solr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/** */
/**
 * author lighter date 2006-8-7
 */
public class DataLucence {
	static String indexPath = "E:\\solr_home\\collection1\\data\\index";

	public static void main(String[] args) throws Exception {
		/**//* 指明要索引文件夹的位置,这里是C盘的S文件夹下 */
		File fileDir = new File("F:\\mytest");

		/**//* 这里放索引文件的位置 */
		File fileIndex = new File("F:\\Index");
		Directory indexDir = FSDirectory.open(fileIndex);
		Analyzer luceneAnalyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		IndexWriter indexWriter = new IndexWriter(indexDir,
				new IndexWriterConfig(Version.LUCENE_CURRENT, luceneAnalyzer));
		File[] textFiles = fileDir.listFiles();
		long startTime = new Date().getTime();

		// 增加document到索引去
		for (int i = 0; i < textFiles.length; i++) {
			if (textFiles[i].isFile()
					&& textFiles[i].getName().endsWith(".txt")) {
				System.out.println(" File  " + textFiles[i].getCanonicalPath()
						+ " 正在被索引. ");
				String temp = readFileContent(textFiles[i]);
				System.out.println(temp);
				Document document = new Document();
				Field FieldPath = new Field("path", textFiles[i].getPath(),
						Field.Store.YES, Field.Index.NO);
				Field FieldBody = new Field("body", temp, Field.Store.YES,
						Field.Index.ANALYZED);
				document.add(FieldPath);
				document.add(FieldBody);
				indexWriter.addDocument(document);
			}
		}
		// optimize()方法是对索引进行优化
		indexWriter.close();

		// 测试一下索引的时间
		long endTime = new Date().getTime();
		System.out.println(" 这花费了" + (endTime - startTime)
				+ "  毫秒来把文档增加到索引里面去! " + fileDir.getPath());
	}

	public static String FileReaderAll(String FileName, String charset)
			throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(FileName), charset));
		String line = new String();
		String temp = new String();

		while ((line = reader.readLine()) != null) {
			temp += line;
		}
		reader.close();
		return temp;
	}

	private static String readFileContent(File file) throws IOException {

		BufferedReader bf = new BufferedReader(new FileReader(file));

		String content = "";
		StringBuilder sb = new StringBuilder();

		while (content != null) {
			content = bf.readLine();

			if (content == null) {
				break;
			}

			sb.append(content.trim());
		}

		bf.close();
		return sb.toString();
	}

}
