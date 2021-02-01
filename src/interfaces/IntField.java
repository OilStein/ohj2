package interfaces;

import javax.swing.SwingConstants;

import fi.jyu.mit.ohj2.Mjonot;

public class IntField extends BasicRecord {
	private int r;
	
	public IntField(String q) {
		super(q);
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
	public String set(int i, String r) {
		StringBuffer sb = new StringBuffer(r);
		try {
			setValue(Mjonot.erota(sb, ' ', 0));
			return null;
		} catch (Exception e) {
			return "Invalid num -> (" +r+")";
		}
	}
	
	
	@Override
	public IntField clone() throws CloneNotSupportedException{
		return (IntField)super.clone();
	}
	
	
	@Override
	public int getLocation(int i) {
		return SwingConstants.RIGHT;
	}


}
