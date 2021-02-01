package interfaces;

import interfaces.Field;
import interfaces.BasicRecord;

public class BaseRecord extends BasicRecord{
	
	private Field fields[] = null;
	private IdField idf = null;
	int first;
	
	private static int nextNum = 1;
	
	@Override
	public Field[] getFields() {
		return fields;
	}
	
	@Override
	protected final void setFields(Field[] f) {
		fields = f;
		idf = null;
		if( fields.length == 0) return;
		Field fField = getField(0);
		if ( !(fField instanceof IdField)) return;
		idf = (IdField)fField;
	}
	
	@Override
	public int getNextNum() {
		if (idf != null) {
			return getNextNum();
		}
		return nextNum;
	}
	
	@Override
	public int register() {
		if ( idf != null) return idf.register();
		return super.register();
	}
	
	@Override
	protected void setNextNum(int i) {
		nextNum = i;
	}
	
	public BaseRecord(Field[] fields, int first) {
		setFields(fields);
		this.first = first;
	}
	
	
	@Override
	public int firstField() {
		return first;
	}


	
	@Override
	public BaseRecord clone() throws CloneNotSupportedException{
		return (BaseRecord)super.clone();
	}

	

}
