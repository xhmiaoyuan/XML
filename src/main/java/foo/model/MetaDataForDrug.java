package foo.model;

import foo.element.big.MetaDataDrug;

public class MetaDataForDrug extends MetaData{
	MetaDataDrug drug;

	public MetaDataDrug getDrug() {
		return drug;
	}

	public void setDrug(MetaDataDrug drug) {
		this.drug = drug;
	}

	@Override
	public String toString() {
		return "MetaDataForDrug [drug=" + drug + "]";
	}
	
	

}
