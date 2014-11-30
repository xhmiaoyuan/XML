package foo.element.big;

import foo.element.smal.MetaDataEvidenceCopyRightDesc;

public class MetaDataAdminMD {


	String Source;
	int EditorVersion;
	MetaDataEvidenceCopyRightDesc CopyRightOwnerID=new MetaDataEvidenceCopyRightDesc();
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public int getEditorVersion() {
		return EditorVersion;
	}
	public void setEditorVersion(int editorVersion) {
		EditorVersion = editorVersion;
	}
	public MetaDataEvidenceCopyRightDesc getCopyRightOwnerID() {
		return CopyRightOwnerID;
	}
	public void setCopyRightOwnerID(MetaDataEvidenceCopyRightDesc copyRightOwnerID) {
		CopyRightOwnerID = copyRightOwnerID;
	}
	@Override
	public String toString() {
		return "MetaDataAdminMD [Source=" + Source + ", EditorVersion="
				+ EditorVersion + ", CopyRightOwnerID=" + CopyRightOwnerID
				+ "]";
	}
	
}
