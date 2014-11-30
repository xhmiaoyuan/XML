package foo.element.smal;

public class MetaDataEvidenceCopyRightDesc {
	String CopyRightID;
	String URL;
	String context;
	public String getCopyRightID() {
		return CopyRightID;
	}
	public void setCopyRightID(String copyRightID) {
		CopyRightID = copyRightID;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "MetaDataEvidenceCopyRightDesc [CopyRightID=" + CopyRightID
				+ ", URL=" + URL + ", context=" + context + "]";
	}
	
}
