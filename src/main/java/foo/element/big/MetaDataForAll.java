package foo.element.big;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import foo.element.smal.ClassCode;

public class MetaDataForAll {

	String Title;
	String EnTitle;
	List<String> Synonyms=new ArrayList<String>();
	String Abstract;
	ClassCode ClassCode;
	List<String> Tag=new ArrayList<String>();	
	List<String> Notes=new ArrayList<String>();
	
	
	public List<String> getNotes() {
		return Notes;
	}
	public void setNotes(List<String> notes) {
		Notes = notes;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getEnTitle() {
		return EnTitle;
	}
	public void setEnTitle(String enTitle) {
		EnTitle = enTitle;
	}
	public String getAbstract() {
		return Abstract;
	}
	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}
	public List<String> getSynonyms() {
		return Synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		Synonyms = synonyms;
	}
	public List<String> getTag() {
		return Tag;
	}
	public void setTag(List<String> tag) {
		Tag = tag;
	}
	public ClassCode getClassCode() {
		return ClassCode;
	}
	public void setClassCode(ClassCode classCode) {
		ClassCode = classCode;
	}
	@Override
	public String toString() {
		return "Title=" + Title + ", EnTitle=" + EnTitle
				+ ", Synonyms=" + Synonyms + ", Abstract=" + Abstract
				+ ", ClassCode=" + ClassCode + ", Tag=" + Tag;
	}

	
	
}