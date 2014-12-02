package foo.mongoDBModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predication {

	String predicateName;
	List<String> objectsList=new ArrayList<String>();
	
	public Predication(){
		
	}
	
	public Predication(String name,List<String> listString){
		this.predicateName=name;
		this.objectsList=listString;
	}
	public String getPredicateName() {
		return predicateName;
	}
	public void setPredicateName(String predicateName) {
		this.predicateName = predicateName;
	}
	public List<String> getObjectsList() {
		return objectsList;
	}
	public void setObjectsList(List<String> objectsList) {
		this.objectsList = objectsList;
	}
	
	
	@Override
	public String toString() {
		return "Predication [predicateName=" + predicateName + ", objectsList="
				+ objectsList + "]";
	}
	
	
	
}
