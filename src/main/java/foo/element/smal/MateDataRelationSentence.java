package foo.element.smal;

import java.util.ArrayList;
import java.util.List;

public class MateDataRelationSentence {

	String Text;
	String SentenceClass;
	List<String> Tags=new ArrayList<String>();
	int Page;
	String BookTitle;
	String MetaID;
	String ObjID;
	String publisher;
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getSentenceClass() {
		return SentenceClass;
	}
	public void setSentenceClass(String sentenceClass) {
		SentenceClass = sentenceClass;
	}
	public List<String> getTags() {
		return Tags;
	}
	public void setTags(List<String> tags) {
		Tags = tags;
	}
	public int getPage() {
		return Page;
	}
	public void setPage(int page) {
		Page = page;
	}
	public String getBookTitle() {
		return BookTitle;
	}
	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}
	public String getMetaID() {
		return MetaID;
	}
	public void setMetaID(String metaID) {
		MetaID = metaID;
	}
	public String getObjID() {
		return ObjID;
	}
	public void setObjID(String objID) {
		ObjID = objID;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
}
