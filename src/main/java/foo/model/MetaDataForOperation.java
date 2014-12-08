package foo.model;

import foo.element.big.MetaDataOperation;

/**
 * @author miaoyuan
 *
 */
public class MetaDataForOperation extends MetaData {
   MetaDataOperation Operation=new MetaDataOperation();

public MetaDataOperation getOperation() {
	return Operation;
}

public void setOperation(MetaDataOperation operation) {
	Operation = operation;
}

@Override
public String toString() {
	return "MetaDataForOperation [Operation=" + Operation + "]";
}

 
	
}
