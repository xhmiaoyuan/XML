package foo.element.smal;

public class MetaDataRelationKnowledge {
	String type;
	String context;
	String ID;
	String relevance;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getRelevance() {
		return relevance;
	}
	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}
	@Override
	public String toString() {
		return "MetaDataRelationKnowledge [type=" + type +", context=" + context + ", ID=" + ID + ", relevance="
				+ relevance + "]";
	}
	

}
