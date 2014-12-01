package foo.model;


import foo.element.big.MetaDataDisease;

public class MetaDataForDisease extends MetaData {

	MetaDataDisease disease;

	public MetaDataDisease getDisease() {
		return disease;
	}

	public void setDisease(MetaDataDisease disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "MetaDataForDisease ["+super.toString()+"disease=" + disease + "]";
	}


}
