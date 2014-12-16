package foo.model;

import foo.element.big.MetaDataSymptom;

public class MetaDataForSymptom extends MetaData{
	
	MetaDataSymptom symptom;

	public MetaDataSymptom getSymptom() {
		return symptom;
	}

	public void setSymptom(MetaDataSymptom symptom) {
		this.symptom = symptom;
	}

	@Override
	public String toString() {
		return "MetaDataForSymptom [symptom=" + symptom + "]";
	}
	
	
}
