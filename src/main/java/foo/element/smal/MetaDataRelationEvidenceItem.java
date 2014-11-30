package foo.element.smal;

public class MetaDataRelationEvidenceItem {

	String Creator;
	String Eabstract;
	String Source;
	String url;
	String context;
	public String getCreator() {
		return Creator;
	}
	public void setCreator(String creator) {
		Creator = creator;
	}
	public String getEabstract() {
		return Eabstract;
	}
	public void setEabstract(String eabstract) {
		Eabstract = eabstract;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "MetaDataRelationEvidenceItem [Creator=" + Creator
				+ ", Eabstract=" + Eabstract + ", Source=" + Source + ", url="
				+ url + ", context=" + context + "]";
	}

	
	
	
}
