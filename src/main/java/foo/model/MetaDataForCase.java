package foo.model;

import java.util.Date;

import foo.element.big.MetaDataAdminMD;
import foo.element.big.MetaDataCase;
import foo.element.big.MetaDataHeader;
import foo.element.big.MetaDataRelations;

public class MetaDataForCase extends MetaData {


	MetaDataCase diseasecase;

	public MetaDataCase getDiseasecase() {
		return diseasecase;
	}

	public void setDiseasecase(MetaDataCase diseasecase) {
		this.diseasecase = diseasecase;
	}

	@Override
	public String toString() {
		return "MetaDataForCase ["+super.toString()+"diseasecase=" + diseasecase + "]";
	}
	
}
