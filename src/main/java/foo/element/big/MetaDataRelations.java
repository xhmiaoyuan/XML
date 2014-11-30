package foo.element.big;

import java.util.ArrayList;
import java.util.List;

import foo.element.smal.MateDataRelationSentence;
import foo.element.smal.MetaDataRelationEvidenceItem;
import foo.element.smal.MetaDataRelationFile;
import foo.element.smal.MetaDataRelationKnowledge;

public class MetaDataRelations {

	List<MetaDataRelationKnowledge> knowledges=new ArrayList<MetaDataRelationKnowledge>();
	List<MetaDataRelationFile> file=new ArrayList<MetaDataRelationFile>();
	List<MateDataRelationSentence> sentences=new ArrayList<MateDataRelationSentence>();
	List<MetaDataRelationEvidenceItem> EvidenceItems=new ArrayList<MetaDataRelationEvidenceItem>();
	
	public List<MetaDataRelationKnowledge> getKnowledges() {
		return knowledges;
	}
	public void setKnowledges(List<MetaDataRelationKnowledge> knowledges) {
		this.knowledges = knowledges;
	}
	public List<MetaDataRelationFile> getFile() {
		return file;
	}
	public void setFile(List<MetaDataRelationFile> file) {
		this.file = file;
	}
	public List<MateDataRelationSentence> getSentences() {
		return sentences;
	}
	public void setSentences(List<MateDataRelationSentence> sentences) {
		this.sentences = sentences;
	}
	public List<MetaDataRelationEvidenceItem> getEvidenceItems() {
		return EvidenceItems;
	}
	public void setEvidenceItems(List<MetaDataRelationEvidenceItem> evidenceItems) {
		EvidenceItems = evidenceItems;
	}
	@Override
	public String toString() {
		return "MetaDataRelations [knowledges=" + knowledges + ", files="
				+ file + ", sentences=" + sentences + ", EvidenceItems="
				+ EvidenceItems + "]";
	}


	
	
}
