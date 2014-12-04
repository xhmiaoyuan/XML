package foo.element.big;

import java.util.Date;

import foo.element.smal.MetaDataCaseDiagnosis;
import foo.element.smal.MetaDataCaseMedicalHistory;
import foo.element.smal.MetaDataCasePic;
import foo.element.smal.MetaDataCasePresent;
import foo.element.smal.MetaDataCasePatient;

public class MetaDataCase extends MetaDataForAll {

	String Creator;
	Date PublishDate;
	MetaDataCasePatient Patient;
	MetaDataCaseMedicalHistory MedicalHistory;
	MetaDataCaseDiagnosis exammination;
	MetaDataCasePic Image;
	MetaDataCasePresent Interpret;
	public String getCreator() {
		return Creator;
	}
	public void setCreator(String creator) {
		Creator = creator;
	}
	public Date getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}
	public MetaDataCasePatient getPatient() {
		return Patient;
	}
	public void setPatient(MetaDataCasePatient patient) {
		Patient = patient;
	}
	public MetaDataCaseMedicalHistory getMedicalHistory() {
		return MedicalHistory;
	}
	public void setMedicalHistory(MetaDataCaseMedicalHistory medicalHistory) {
		MedicalHistory = medicalHistory;
	}
	public MetaDataCaseDiagnosis getExammination() {
		return exammination;
	}
	public void setExammination(MetaDataCaseDiagnosis exammination) {
		this.exammination = exammination;
	}
	public MetaDataCasePic getImage() {
		return Image;
	}
	public void setImage(MetaDataCasePic image) {
		Image = image;
	}
	public MetaDataCasePresent getInterpret() {
		return Interpret;
	}
	public void setInterpret(MetaDataCasePresent interpret) {
		Interpret = interpret;
	}
	@Override
	public String toString() {
		return "MetaDataCase [Creator=" + Creator + ", PublishDate="
				+ PublishDate + ", Patient=" + Patient + ", MedicalHistory="
				+ MedicalHistory + ", exammination=" + exammination
				+ ", Image=" + Image + ", Interpret=" + Interpret + "]";
	}
	
}