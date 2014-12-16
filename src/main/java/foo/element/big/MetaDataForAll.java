package foo.element.big;

import java.util.ArrayList;
import java.util.List;

import foo.element.smal.ClassCode;

public class MetaDataForAll {

	String Title;
	List<String> Synonyms=new ArrayList<String>();
	String Abstract;
	List<ClassCode> ClassCode=new ArrayList<ClassCode>();
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
	public List<ClassCode> getClassCode() {
		return ClassCode;
	}
	public void setClassCode(List<ClassCode> classCode) {
		ClassCode = classCode;
	}
	@Override
	public String toString() {
		return "MetaDataForAll [EnTitle=" + Title + ", Synonyms=" + Synonyms
				+ ", Abstract=" + Abstract + ", ClassCode=" + ClassCode
				+ ", Tag=" + Tag + ", Notes=" + Notes + "]";
	}
	
	
	
}
