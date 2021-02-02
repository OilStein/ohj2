package interfaces;

import javax.swing.SwingConstants;

import fi.jyu.mit.ohj2.Mjonot;

public class IntField extends BasicField {
	private int r;
	
	public IntField(String question) {
		super(question);
	}
	
	public int getValue() {
		return r;
	}
	
	public void getValue(int v) {
		r = v;
	}
	
	public void setValue(int v) {
		r = v;
	}
	
	@Override
	public String toString() {
		return ""+r;
	}
	
	@Override
	public String set(String r) {
		StringBuffer sb = new StringBuffer(r);
		try {
			setValue(Mjonot.erotaEx(sb, ' ', 0));
			return null;
		} catch (NumberFormatException e) {
			return "Invalid num -> (" +r+")";
		}
	}
	
	@Override
	public String getKey() {
		return Mjonot.fmt(r, 10);
	}
	
	
	@Override
	public IntField clone() throws CloneNotSupportedException{
		return (IntField)super.clone();
	}

	@Override
	public int compareTo(Field f) {
		if ( !(f instanceof IntField)) return super.compareTo(f);
		return getValue()- ((IntField)f).getValue();
	}
	
	@Override
	public int getLocation() {
		return SwingConstants.RIGHT;
	}

}
