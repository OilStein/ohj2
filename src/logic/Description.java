package logic;

import interfaces.BaseRecord;
import interfaces.Field;
import interfaces.IdField;
import interfaces.IntField;
import interfaces.StringField;

public class Description extends BaseRecord{
	
	public Description() {
		super(new Field[] {
			new IdField("id", "descId"),
			new IntField("spellid"),
			new StringField("description")
		},2);
	}
	
	private IntField getSpellidField() {
		return (IntField)(getField(1));
	}
	
	public int getSpellid() {
		return getSpellidField().getValue();
	}
	
	public Description(int spellid) {
		this();
		getSpellidField().setValue(spellid);
	}
}
