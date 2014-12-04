package foo.element.big;


public class MetaDataExamination extends MetaDataForAll {

	String Indication;
	String Contraindications;
	String Method;
	String Sense;
	public String getIndication() {
		return Indication;
	}
	public void setIndication(String indication) {
		Indication = indication;
	}
	public String getContraindications() {
		return Contraindications;
	}
	public void setContraindications(String contraindications) {
		Contraindications = contraindications;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getSense() {
		return Sense;
	}
	public void setSense(String sense) {
		Sense = sense;
	}
	@Override
	public String toString() {
		return "MetaDataExamination [Indication=" + Indication
				+ ", Contraindication=" + Contraindications + ", Method="
				+ Method + ", Sense=" + Sense + "]";
	}
	
	
}
