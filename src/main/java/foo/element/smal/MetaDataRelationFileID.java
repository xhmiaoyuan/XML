package foo.element.smal;

public class MetaDataRelationFileID {
	String ObjID;
	String PObjID;

	public String getObjID() {
		return ObjID;
	}

	public void setObjID(String objID) {
		ObjID = objID;
	}

	public String getPObjID() {
		return PObjID;
	}

	public void setPObjID(String pObjID) {
		PObjID = pObjID;
	}

	@Override
	public String toString() {
		return "MetaDataRelationFileID [ObjID=" + ObjID + ", PObjID=" + PObjID
				+ "]";
	}

	
}
