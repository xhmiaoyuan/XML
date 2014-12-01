package foo.model;

import foo.element.big.MetaDataAdminMD;
import foo.element.big.MetaDataHeader;
import foo.element.big.MetaDataRelations;

public class MetaData {

	MetaDataHeader header;
	MetaDataRelations relation;
	MetaDataAdminMD adminMD;
	public MetaDataHeader getHeader() {
		return header;
	}
	public void setHeader(MetaDataHeader header) {
		this.header = header;
	}
	public MetaDataRelations getRelation() {
		return relation;
	}
	public void setRelation(MetaDataRelations relation) {
		this.relation = relation;
	}
	public MetaDataAdminMD getAdminMD() {
		return adminMD;
	}
	public void setAdminMD(MetaDataAdminMD adminMD) {
		this.adminMD = adminMD;
	}
	@Override
	public String toString() {
		return " header=" + header + ", relation=" + relation
				+ ", adminMD=" + adminMD;
	}
	
	
}
