package foo.model;

import foo.element.big.MetaDataExamination;

public class MetaDataForExamination extends MetaData{

	MetaDataExamination examination;

	public MetaDataExamination getExamination() {
		return examination;
	}

	public void setExamination(MetaDataExamination examination) {
		this.examination = examination;
	}

	@Override
	public String toString() {
		return "MetaDataForExamination [examination=" + examination + "]";
	}
	
	
}
