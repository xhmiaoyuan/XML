package foo.mongoDBModel;

public class Sentence {
	long relationnum;
	String content;
	String objectid;
	String metaid;
	String title;
	int ebookpageNum;
	String publisher;
	public long getRelationnum() {
		return relationnum;
	}
	public void setRelationnum(long relationnum) {
		this.relationnum = relationnum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
	public String getMetaid() {
		return metaid;
	}
	public void setMetaid(String metaid) {
		this.metaid = metaid;
	}
	public int getEbookpageNum() {
		return ebookpageNum;
	}
	public void setEbookpageNum(int ebookpageNum) {
		this.ebookpageNum = ebookpageNum;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
