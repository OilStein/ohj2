package interfaces;

import javax.swing.SwingConstants;

public abstract class BasicField implements Field {
	private String q;
	
	protected Checker c = null;
	
	public BasicField(String q) {
		this.q = q;
	}
	
	
	public BasicField(String q, Checker c) {
		this.q = q;
		this.c = c;
	}
	
	
	@Override
	public abstract String toString();
	
	@Override
	public String getQ() {
		return q;
	}
	
	@Override
	public void setQ(String q) {
		this.q = q;
	}
	
	@Override
	public String getKey() {
		return toString().toUpperCase();
	}
	
	@Override
	public int compareTo(Field o) {
		return getKey().compareTo(o.getKey());
	}
	
	@Override
	public int getLocation() {
		return SwingConstants.LEFT;
	}
	
	
	@Override
	public Field clone() throws CloneNotSupportedException {
		return (Field)super.clone();
	}
}
