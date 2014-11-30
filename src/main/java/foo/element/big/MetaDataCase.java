package foo.element.big;

import foo.element.smal.MetaDataCasePic;
import foo.element.smal.MetaDataCasePresent;
import foo.element.smal.MetaDataPatient;

public class MetaDataCase extends MetaDataForAll {

	String Creator;
	String PublishDate;
	MetaDataPatient Patient;
	String MedicalHistory;
	String Examination;
	MetaDataCasePic Pic;
	MetaDataCasePresent Present;
	public String getCreator() {
		return Creator;
	}
	public void setCreator(String creator) {
		Creator = creator;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public MetaDataPatient getPatient() {
		return Patient;
	}
	public void setPatient(MetaDataPatient patient) {
		Patient = patient;
	}
	public String getMedicalHistory() {
		return MedicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		MedicalHistory = medicalHistory;
	}
	public String getExamination() {
		return Examination;
	}
	public void setExamination(String examination) {
		Examination = examination;
	}
	public MetaDataCasePic getPic() {
		return Pic;
	}
	public void setPic(MetaDataCasePic pic) {
		Pic = pic;
	}
	public MetaDataCasePresent getPresent() {
		return Present;
	}
	public void setPresent(MetaDataCasePresent present) {
		Present = present;
	}
	
}