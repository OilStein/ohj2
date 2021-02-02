package interfaces;

import javax.swing.SwingConstants;

public abstract class BasicField implements Field {
	private String question;
	
	protected Checker checker = null;
	
	public BasicField(String q) {
		this.question = q;
	}
	
	
	public BasicField(String q, Checker c) {
		this.question = q;
		this.checker = c;
	}
	
	
	@Override
	public abstract String toString();
	
	@Override
	public String getQ() {
		return question;
	}
	
	@Override
	public void setQ(String q) {
		this.question = q;
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
