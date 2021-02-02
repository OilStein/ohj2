package interfaces;

public class StringField extends BasicField {
	private String s = "";
	
	public StringField(String q) {
		super(q);
	}
	
	public StringField(String q, Checker c) {
		super(q,c);
	}
	
	@Override
	public String toString() {
		return s;
	}
	
	@Override
	public String set(String st) {
		if( checker == null) {
			this.s = st;
			return null;
		}
		
		String error = checker.check(s);
		if(error == null) {
			this.s = st;
			return null;
		}
		
		return error;
	}
}
