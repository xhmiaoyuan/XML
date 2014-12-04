package foo.element.smal;

public class MetaDataCasePresent {

	String Interpret;
	String Video;
	String Person;
	String Organization;
	public String getInterpret() {
		return Interpret;
	}
	public void setInterpret(String interpret) {
		Interpret = interpret;
	}
	public String getVideo() {
		return Video;
	}
	public void setVideo(String video) {
		Video = video;
	}
	public String getPerson() {
		return Person;
	}
	public void setPerson(String person) {
		Person = person;
	}
	public String getOrganization() {
		return Organization;
	}
	public void setOrganization(String organization) {
		Organization = organization;
	}
	@Override
	public String toString() {
		return "MetaDataCasePresent [Interpret=" + Interpret + ", Video="
				+ Video + ", Person=" + Person + ", Organization="
				+ Organization + "]";
	}
	
}
