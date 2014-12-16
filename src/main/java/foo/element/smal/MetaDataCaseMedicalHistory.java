package foo.element.smal;

public class MetaDataCaseMedicalHistory {
	String Statement;
	String PresentIllness;
	String PreviousHistory;
	String FamilyHistory;
	String SpecialCheck;
	String Labortory;
	String TreatmentProcess;
	public String getStatement() {
		return Statement;
	}
	public void setStatement(String statement) {
		Statement = statement;
	}
	public String getPresentIllness() {
		return PresentIllness;
	}
	public void setPresentIllness(String presentIllness) {
		PresentIllness = presentIllness;
	}
	public String getPreviousHistory() {
		return PreviousHistory;
	}
	public void setPreviousHistory(String previousHistory) {
		PreviousHistory = previousHistory;
	}
	public String getFamilyHistory() {
		return FamilyHistory;
	}
	public void setFamilyHistory(String familyHistory) {
		FamilyHistory = familyHistory;
	}
	public String getSpecialCheck() {
		return SpecialCheck;
	}
	public void setSpecialCheck(String specialCheck) {
		SpecialCheck = specialCheck;
	}
	public String getLabortory() {
		return Labortory;
	}
	public void setLabortory(String labortory) {
		Labortory = labortory;
	}
	public String getTreatmentProcess() {
		return TreatmentProcess;
	}
	public void setTreatmentProcess(String treatmentProcess) {
		TreatmentProcess = treatmentProcess;
	}
	@Override
	public String toString() {
		return "MetaDataCaseMedicalHistory [Statement=" + Statement
				+ ", PresentIllness=" + PresentIllness + ", PreviousHistory="
				+ PreviousHistory + ", FamilyHistory=" + FamilyHistory
				+ ", SpecialCheck=" + SpecialCheck + ", Labortory=" + Labortory
				+ ", TreatmentProcess=" + TreatmentProcess + "]";
	}
	

}
