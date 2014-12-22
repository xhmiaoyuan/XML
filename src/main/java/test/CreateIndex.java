package test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;

public class CreateIndex {
	public static boolean createDocumentIndex() {
		boolean bool = false;
		// 被索引的目录文件夹
		File dirpath = new File("E:\\documentTest");
		// 索引文件存放的目录文件夹
		File path = new File("E:\\Index");
		Directory indexpath=null;
		try {
			indexpath = FSDirectory.open(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 分词，分词有StandardAnalyzer和SimpleAnalyzer两种
		// lucene是将一句句话，一段话Field，分成一个个词Term进行索引搜索的。
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
		IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_CURRENT,analyzer);
		try {
			// 向E:\\Index保存建立的索引Index内容
			// 用到IndexWriter类，这里需要传入的三个参数为：
			// （索引目录文件夹，分词）
			IndexWriter index = new IndexWriter(indexpath, config);
			File[] txtfiles = dirpath.listFiles();
			for (int i = 0; i < txtfiles.length; i++) {
				if (txtfiles[i].isFile()
						&& txtfiles[i].getName().endsWith(".txt")) {
					System.out.println("文件" + txtfiles[i].getCanonicalPath()
							+ "正在索引中。。。");
					// Read将txt内容存进内存
					Reader read = new FileReader(txtfiles[i]);
					// 创建Document的实例
					Document doc = new Document();
					// 将field存进索引的Document
					// Document添加读取的文章内容（缓存在内存中的文章内容read）
					doc.add(new Field("content", read));
					// Document添加文章对应路径信息等
					//
					doc.add(new Field("path", txtfiles[i].getAbsolutePath(),
							Field.Store.YES, Field.Index.NO));
					// index加Document，索引创建成功
					index.addDocument(doc);
				}
			}
			// 索引优化optimize()，合并磁盘上的索引文件，以便减少文件的数量，从而也减少搜索索引的时间
			//index.optimize();
			// 注意关闭IndexWriter，立即将索引文件写入到目录磁盘中，生成索引文件
			index.close();
			long endTime = new Date().getTime();
//			System.out.println("共花了" + (endTime - startTime) + "毫秒将文档增加到索引中"
//					+ indexpath.);
			bool = true;
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	public static void main(String[] a) {
		createDocumentIndex();
	}
}
