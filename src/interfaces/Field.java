package interfaces;

public interface Field extends Cloneable, Comparable<Field> {
	
	@Override
	String toString();
	
	String getQ();
	
	void setQ(String q);
	
	String set(String s);
	
	String getKey();
	
	Field clone() throws CloneNotSupportedException;
	
	int getLocation();
	

}
