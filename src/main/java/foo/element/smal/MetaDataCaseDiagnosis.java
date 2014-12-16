package foo.element.smal;

public class MetaDataCaseDiagnosis {
	String ACRSystem;
	String ACRCode;
	String ACRDiagosis;
	String Diagnosis;
	String BelongTo;
	String DiagnosisWay;
	String PathologicalResult;
	String Degree;
	String ICD10;
	String Discussion;
	public String getACRSystem() {
		return ACRSystem;
	}
	public void setACRSystem(String aCRSystem) {
		ACRSystem = aCRSystem;
	}
	public String getACRCode() {
		return ACRCode;
	}
	public void setACRCode(String aCRCode) {
		ACRCode = aCRCode;
	}
	public String getACRDiagosis() {
		return ACRDiagosis;
	}
	public void setACRDiagosis(String aCRDiagosis) {
		ACRDiagosis = aCRDiagosis;
	}
	public String getDiagnosis() {
		return Diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		Diagnosis = diagnosis;
	}
	public String getBelongTo() {
		return BelongTo;
	}
	public void setBelongTo(String belongTo) {
		BelongTo = belongTo;
	}
	public String getDiagnosisWay() {
		return DiagnosisWay;
	}
	public void setDiagnosisWay(String diagnosisWay) {
		DiagnosisWay = diagnosisWay;
	}
	public String getPathologicalResult() {
		return PathologicalResult;
	}
	public void setPathologicalResult(String pathologicalResult) {
		PathologicalResult = pathologicalResult;
	}
	public String getDegree() {
		return Degree;
	}
	public void setDegree(String degree) {
		Degree = degree;
	}
	public String getICD10() {
		return ICD10;
	}
	public void setICD10(String iCD10) {
		ICD10 = iCD10;
	}
	public String getDiscussion() {
		return Discussion;
	}
	public void setDiscussion(String discussion) {
		Discussion = discussion;
	}
	@Override
	public String toString() {
		return "MetaDataCaseDiagnosis [ACRSystem=" + ACRSystem + ", ACRCode="
				+ ACRCode + ", ACRDiagosis=" + ACRDiagosis + ", Diagnosis="
				+ Diagnosis + ", BelongTo=" + BelongTo + ", DiagnosisWay="
				+ DiagnosisWay + ", PathologicalResult=" + PathologicalResult
				+ ", Degree=" + Degree + ", ICD10=" + ICD10 + ", Discussion="
				+ Discussion + "]";
	}
	

}
