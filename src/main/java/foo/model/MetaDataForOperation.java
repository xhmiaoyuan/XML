package foo.model;

import foo.element.big.MetaDataOperation;

/**
 * @author miaoyuan
 *
 */
public class MetaDataForOperation extends MetaData {
   MetaDataOperation metaDataOperation=new MetaDataOperation();

public MetaDataOperation getMetaDataOperation() {
	return metaDataOperation;
}

public void setMetaDataOperation(MetaDataOperation metaDataOperation) {
	this.metaDataOperation = metaDataOperation;
}

@Override
public String toString() {
	return "MetaDataForOperation [metaDataOperation=" + metaDataOperation + "]";
}
   
	
}
