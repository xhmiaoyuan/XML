package foo.model;

import java.util.Date;

import foo.element.big.MetaDataAdminMD;
import foo.element.big.MetaDataCase;
import foo.element.big.MetaDataHeader;
import foo.element.big.MetaDataRelations;

public class MetaDataForCase {


	MetaDataHeader header;
	MetaDataCase diseasecase;
	MetaDataRelations relation;
	MetaDataAdminMD adminMD;
	public MetaDataHeader getHeader() {
		return header;
	}
	public void setHeader(MetaDataHeader header) {
		this.header = header;
	}
	public MetaDataCase getDiseasecase() {
		return diseasecase;
	}
	public void setDiseasecase(MetaDataCase diseasecase) {
		this.diseasecase = diseasecase;
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
	
	
	
	
}
