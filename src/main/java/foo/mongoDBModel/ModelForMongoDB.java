package foo.mongoDBModel;

import java.util.ArrayList;
import java.util.List;

public class ModelForMongoDB {

	private String subjectumId;
	private String name;
	private List<Predication> predicateList=new ArrayList<Predication>();
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
	@Override
	public String toString() {
		return "DiseaseForMongoDB [subjectumId=" + subjectumId + ", name="
				+ name + ", predicateList=" + predicateList + "]";
	}
	
	

	
}
