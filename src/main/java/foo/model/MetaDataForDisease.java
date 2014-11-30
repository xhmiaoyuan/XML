package foo.model;

import foo.element.big.MetaDataAdminMD;
import foo.element.big.MetaDataDisease;
import foo.element.big.MetaDataHeader;
import foo.element.big.MetaDataRelations;

public class MetaDataForDisease {
	MetaDataHeader header;
	MetaDataDisease disease;
	MetaDataRelations relations;
	MetaDataAdminMD admimMD;
	public MetaDataHeader getHeader() {
		return header;
	}
	public void setHeader(MetaDataHeader header) {
		this.header = header;
	}
	public MetaDataDisease getDisease() {
		return disease;
	}
	public void setDisease(MetaDataDisease disease) {
		this.disease = disease;
	}
	public MetaDataRelations getRelations() {
		return relations;
	}
	public void setRelations(MetaDataRelations relations) {
		this.relations = relations;
	}
	public MetaDataAdminMD getAdmimMD() {
		return admimMD;
	}
	public void setAdmimMD(MetaDataAdminMD admimMD) {
		this.admimMD = admimMD;
	}
	

}
