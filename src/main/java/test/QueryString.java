package test;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

public class QueryString {

	public static void main(String[] args) throws CorruptIndexException, IOException {
		//想搜索的词
		String queryStr="鬼婆";
		//索引目录
		File indexDir=new File("E:\\Index");
		//创建directory，Index的映射地址，相当于电话本
		FSDirectory directory=FSDirectory.open(indexDir);
		IndexReader reader=IndexReader.open(directory);
		IndexSearcher searcher2=new IndexSearcher(reader);
		if(!indexDir.exists()){
			System.out.println("索引目录不存在");
			return;
		}
		//从Document的”content“中查找关键字，而在此之前文章全部变成小写toLowerCase（）
		Term term=new Term("content",queryStr.toLowerCase());
		//查询命令
		TermQuery luceneQuery=new TermQuery(term);
		//结果保存在Hits中
		ScoreDoc[] hits2=searcher2.search(luceneQuery, 10).scoreDocs;
		for(int j=0;j<hits2.length;j++){
			Document document=searcher2.doc(hits2[j].doc);
			System.out.println("File:"+document.get("path"));
		}
		
		
	}

}
