package interfaces;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public interface Record {
	
	public abstract int getData();
	
	public abstract int firstField(); 
	
	public abstract Field getField(int i);
	
	public abstract Field[] getFields();
	
	public abstract String getQ(int q);
	
	public void setQ(int q, String qn);
	
	public abstract String[] getHead();
	
	public abstract String get(int g);
		
	public abstract String set(int n, String s);
	
	public abstract int getInt(int i);
	
	public abstract Record clone() throws CloneNotSupportedException;
	
	public abstract void print(PrintWriter pw);
	
	public abstract void print(OutputStream os);
	
	public abstract void print(PrintStream ps);
	
	public abstract int register();
	
	public abstract int getIdNum();
	
	public abstract int setIdNum(int num);
	
	@Override
	public abstract String toString();
	
	public abstract void parse(String l);
	
	public int getNextNum();
	
	@Override
	public abstract boolean equals(Object data);
	
	int getLocation(int l);

}
