package foo.solr;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.IKAnalyzerWithSmart;

import foo.PushDataToSolr;

public class SolrQuery {

	public static void main(String[] args) throws IOException, ParseException {

		//Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		
		IKAnalyzerWithSmart ikAnalyzer=new IKAnalyzerWithSmart(true);
		String filePath = PushDataToSolr.class.getResource("").getPath();
		filePath = filePath.substring(0, filePath.indexOf("classes") + 7);
		System.out.println(filePath);
		// "E:\\eclipseWorlk\\Java\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\founder.medical\\WEB-INF\\classes"
		ikAnalyzer.setConfigFilePath(filePath);
		Directory dir = FSDirectory.open(new File("E:\\solr_home\\collection1\\data\\index"));
		// Now search the index:
		//DirectoryReader ireader = DirectoryReader.open(dir);
		IndexReader reader=IndexReader.open(dir);
		IndexSearcher isearcher = new IndexSearcher(reader);
		Term term=new Term("Name","NN3GYSTD");
		TermQuery termquery=new TermQuery(term);
		Analyzer any=new StandardAnalyzer(Version.LUCENE_CURRENT);
		// Parse a simple query that searches for "text":
		QueryParser parser = new QueryParser(Version.LUCENE_CURRENT,
				"Abstract", any);
		//"ID": "NNKMNmDM"
		Query query = parser.parse("克罗恩病");
		ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
		
		// AssertEquals(1, hits.length);
		// Iterate through the results:
		for (int i = 0; i < hits.length; i++) {
			Document hitDoc = isearcher.doc(hits[i].doc);
			// assertEquals("This is the text to be indexed.",
			// hitDoc.get("fieldname"));
			System.out.println(hitDoc.toString());
		}
		
		dir.close();
	}

}