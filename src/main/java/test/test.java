package test;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
//import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.IKAnalyzerWithSmart;

import foo.PushDataToSolr;

public class test {
	// private static final Directory IndexReader = null;

	public static void main(String args[]) throws Exception {
	    File INDEX_DIR = new File("E:\\temp\\index");

		Directory indexpath = null;
		IndexWriter indexWriter = null;
		Analyzer luceneAnalyzer;
		IKAnalyzerWithSmart ikAnalyzer = null;
		try {
			indexpath = FSDirectory.open(INDEX_DIR);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		luceneAnalyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		ikAnalyzer = new IKAnalyzerWithSmart(true);
		String filePath = PushDataToSolr.class.getResource("").getPath();
		filePath = filePath.substring(0, filePath.indexOf("classes") + 7);
		// "E:\\eclipseWorlk\\Java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\founder.medical\\WEB-INF\\classes"

		ikAnalyzer.setConfigFilePath(filePath);
		try {
			indexWriter = new IndexWriter(indexpath, new IndexWriterConfig(
					Version.LUCENE_CURRENT, ikAnalyzer));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String str = "你好俊杰，这是成功的开始！加油！";
		Document doc = new Document();
		doc.add(new Field("contents", str, Field.Store.YES,
				Field.Index.ANALYZED));
		indexWriter.addDocument(doc);

		str = "希望能够实现这一个项目，俊杰你可以的！";
		doc = new Document();
		doc.add(new Field("contents", str, Field.Store.YES,
				Field.Index.ANALYZED));
		indexWriter.addDocument(doc);

		indexWriter.close();

		FSDirectory directory=FSDirectory.open(INDEX_DIR);
		IndexReader reader=IndexReader.open(directory);
		IndexSearcher searcher2=new IndexSearcher(reader);
		String queryStr="希";
		if(!INDEX_DIR.exists()){
			System.out.println("索引目录不存在");
			return;
		}
		//从Document的”content“中查找关键字，而在此之前文章全部变成小写toLowerCase（）
		Term term=new Term("contents",queryStr);
		//查询命令
		TermQuery luceneQuery=new TermQuery(term);
		//结果保存在Hits中
		ScoreDoc[] hits2=searcher2.search(luceneQuery, 10).scoreDocs;
		for(int j=0;j<hits2.length;j++){
			Document document=searcher2.doc(hits2[j].doc);
			System.out.println(document);
		}
		

	}
}
