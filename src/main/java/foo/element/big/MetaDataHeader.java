package foo.element.big;

import java.util.Date;

public class MetaDataHeader {
	

	String MetaDataVersion;
	 String MetaDataID;
	 String Identifier;
	 String IdentifierIDType;
	 String complexOID;
	 Date createDate;
	 Date lastModifiedDate;
	public String getMetaDataVersion() {
		return MetaDataVersion;
	}
	public void setMetaDataVersion(String metaDataVersion) {
		MetaDataVersion = metaDataVersion;
	}
	public String getMetaDataID() {
		return MetaDataID;
	}
	public void setMetaDataID(String metaDataID) {
		MetaDataID = metaDataID;
	}
	public String getIdentifier() {
		return Identifier;
	}
	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}
	public String getIdentifierIDType() {
		return IdentifierIDType;
	}
	public void setIdentifierIDType(String identifierIDType) {
		IdentifierIDType = identifierIDType;
	}
	public String getComplexOID() {
		return complexOID;
	}
	public void setComplexOID(String complexOID) {
		this.complexOID = complexOID;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	@Override
	public String toString() {
		return "MetaDataHeader [MetaDataVersion=" + MetaDataVersion
				+ ", MetaDataID=" + MetaDataID + ", Identifier=" + Identifier
				+ ", IdentifierIDType=" + IdentifierIDType + ", complexOID="
				+ complexOID + ", createDate=" + createDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	 
	
}
