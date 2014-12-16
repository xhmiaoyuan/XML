package foo;

import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
public class T {
	 public static void main(String []args)throws Exception {
	        
	        String []id = {"1","2","3"};
	        String []contents = {"java and lucene is good","I had study java and jbpm","I want to study java,hadoop and hbase"};
	        
	        Directory directory = new RAMDirectory();
	        IndexWriter indexWriter = new IndexWriter(directory,new IndexWriterConfig(Version.LUCENE_34, new StandardAnalyzer(Version.LUCENE_34)));
	        for(int i=0;i<id.length;i++){
	            Document document = new Document();
	            document.add(new Field("id",id[i],Field.Store.YES,Field.Index.ANALYZED));
	            document.add(new Field("contents",contents[i],Field.Store.YES,Field.Index.ANALYZED));
	            indexWriter.addDocument(document);
	        }
	        indexWriter.close();
	        
	        System.out.println("String is :java");
	        search(directory,"java");
	        
	        System.out.println("\nString is :lucene");
	        search(directory,"lucene");
	        
	        System.out.println("\nString is :+java +jbpm");
	        search(directory,"+java +jbpm");
	        
	        System.out.println("\nString is :+java -jbpm");
	        search(directory,"+java -jbpm");
	        
	        System.out.println("\nString is :java jbpm");
	        search(directory,"java jbpm");
	        
	        System.out.println("\nString is :java AND jbpm");
	        search(directory,"java AND jbpm");
	        
	        System.out.println("\nString is :java or jbpm");
	        search(directory,"java or jbpm");
	    }
	    
	    public static void search(Directory directory,String str)throws Exception {
	    	
	    	
	    	
			// Now search the index:
			DirectoryReader ireader = DirectoryReader.open(directory);
	        IndexSearcher indexSearcher = new IndexSearcher(ireader);
	        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_34);
	        QueryParser queryParser = new QueryParser(Version.LUCENE_34,"contents",analyzer);
	        Query query = queryParser.parse(str);
	        TopDocs topDocs = indexSearcher.search(query, 2);
	        ScoreDoc [] scoreDoc = topDocs.scoreDocs;
	        for(int i =0;i<scoreDoc.length;i++){
	            Document doc = indexSearcher.doc(scoreDoc[i].doc);
	            System.out.println(doc.get("id")+" "+doc.get("contents"));
	        }
	       // indexSearcher.close();
	    }
}
