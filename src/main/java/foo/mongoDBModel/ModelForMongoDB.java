package foo.mongoDBModel;

import java.util.ArrayList;
import java.util.List;

public class ModelForMongoDB {

	private String subjectumId;
	private String name;
	private List<Predication> predicateList=new ArrayList<Predication>();
	private List<Image> imageList= new ArrayList<Image>();
	private List<Tag> tagList=new ArrayList<Tag>();
	private List<Sentence> sentenceList=new ArrayList<Sentence>();
	private List<Route> routeList=new ArrayList<Route>();
	private List<Video> videoList=new ArrayList<Video>();
	private List<Evidence> evidenceList=new ArrayList<Evidence>();
	public String getSubjectumId() {
		return subjectumId;
	}
	public void setSubjectumId(String subjectumId) {
		this.subjectumId = subjectumId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Predication> getPredicateList() {
		return predicateList;
	}
	public void setPredicateList(List<Predication> predicateList) {
		this.predicateList = predicateList;
	}
	public List<Image> getImageList() {
		return imageList;
	}
	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public List<Sentence> getSentenceList() {
		return sentenceList;
	}
	public void setSentenceList(List<Sentence> sentenceList) {
		this.sentenceList = sentenceList;
	}
	public List<Video> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}
	public List<Route> getRouteList() {
		return routeList;
	}
	public void setRouteList(List<Route> routeList) {
		this.routeList = routeList;
	}
	public List<Evidence> getEvidenceList() {
		return evidenceList;
	}
	public void setEvidenceList(List<Evidence> evidenceList) {
		this.evidenceList = evidenceList;
	}
	

	
	
	
	
}
