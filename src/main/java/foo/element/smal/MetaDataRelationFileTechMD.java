package foo.element.smal;

public class MetaDataRelationFileTechMD {

	String FileTitle;
	String FileDesc;
	String FileSize;
	String Format;
	int EncryptInfo;
	String ObjType;
	long Width;
	long Height;
	String FileNotes;
	public String getFileTitle() {
		return FileTitle;
	}
	public void setFileTitle(String fileTitle) {
		FileTitle = fileTitle;
	}
	public String getFileDesc() {
		return FileDesc;
	}
	public void setFileDesc(String fileDesc) {
		FileDesc = fileDesc;
	}
	public String getFileSize() {
		return FileSize;
	}
	public void setFileSize(String fileSize) {
		FileSize = fileSize;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public int getEncryptInfo() {
		return EncryptInfo;
	}
	public void setEncryptInfo(int encryptInfo) {
		EncryptInfo = encryptInfo;
	}
	public String getObjType() {
		return ObjType;
	}
	public void setObjType(String objType) {
		ObjType = objType;
	}
	public long getWidth() {
		return Width;
	}
	public void setWidth(long width) {
		Width = width;
	}
	public long getHeight() {
		return Height;
	}
	public void setHeight(long height) {
		Height = height;
	}
	public String getFileNotes() {
		return FileNotes;
	}
	public void setFileNotes(String fileNotes) {
		FileNotes = fileNotes;
	}
	@Override
	public String toString() {
		return "MetaDataRelationFileTechMD [FileTitle=" + FileTitle
				+ ", FileDesc=" + FileDesc + ", FileSize=" + FileSize
				+ ", Format=" + Format + ", EncryptInfo=" + EncryptInfo
				+ ", ObjType=" + ObjType + ", Width=" + Width + ", Height="
				+ Height + ", FileNotes=" + FileNotes + "]";
	}
	
	
}
