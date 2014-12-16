package foo.mongoDBModel;

import java.util.ArrayList;
import java.util.List;

public class Tag {

	String predicate;
	List<String> tagList=new ArrayList<String>();
	public String getPredicate() {
		return predicate;
	}
	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}
	public List<String> getTagList() {
		return tagList;
	}
	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}
	
	
}
