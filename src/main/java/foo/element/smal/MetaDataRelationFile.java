package foo.element.smal;


public class MetaDataRelationFile {

	@Override
	public String toString() {
		return "MetaDataRelationFile [FileName=" + FileName + ", FilePath="
				+ FilePath + ", FileDesc=" + FileDesc + ", Order=" + Order
				+ ", id=" + id + ", techMD=" + techMD + "]";
	}
	String FileName;
	String FilePath;
	String FileDesc;
	int Order;
	MetaDataRelationFileID id=new MetaDataRelationFileID();
	MetaDataRelationFileTechMD techMD=new MetaDataRelationFileTechMD();
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFilePath() {
		return FilePath;
	}
	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	public String getFileDesc() {
		return FileDesc;
	}
	public void setFileDesc(String fileDesc) {
		FileDesc = fileDesc;
	}
	public int getOrder() {
		return Order;
	}
	public void setOrder(int order) {
		Order = order;
	}
	public MetaDataRelationFileID getId() {
		return id;
	}
	public void setId(MetaDataRelationFileID id) {
		this.id = id;
	}
	public MetaDataRelationFileTechMD getTechMD() {
		return techMD;
	}
	public void setTechMD(MetaDataRelationFileTechMD techMD) {
		this.techMD = techMD;
	}
	
	
	
	
}
