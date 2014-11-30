package foo.element.big;

import java.util.List;

public class MetaDataDisease extends MetaDataForAll {
	String Cause;
	String Symptom;
	String Therapy;
	String Disagnosis;
	String Prevention;
	String Prognosis;
	public String getCause() {
		return Cause;
	}
	public void setCause(String cause) {
		Cause = cause;
	}
	public String getSymptom() {
		return Symptom;
	}
	public void setSymptom(String symptom) {
		Symptom = symptom;
	}
	public String getTherapy() {
		return Therapy;
	}
	public void setTherapy(String therapy) {
		Therapy = therapy;
	}
	public String getDisagnosis() {
		return Disagnosis;
	}
	public void setDisagnosis(String disagnosis) {
		Disagnosis = disagnosis;
	}
	public String getPrevention() {
		return Prevention;
	}
	public void setPrevention(String prevention) {
		Prevention = prevention;
	}
	public String getPrognosis() {
		return Prognosis;
	}
	public void setPrognosis(String prognosis) {
		Prognosis = prognosis;
	}
	@Override
	public String toString() {
		return "MetaDataDisease ["+super.toString()+", Cause=" + Cause + ", Symptom=" + Symptom
				+ ", Therapy=" + Therapy + ", Disagnosis=" + Disagnosis
				+ ", Prevention=" + Prevention + ", Prognosis=" + Prognosis
				+ "]";
	}
	

}
