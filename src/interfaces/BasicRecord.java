package interfaces;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import fi.jyu.mit.ohj2.Mjonot;

public abstract class BasicRecord implements Cloneable, Record {
	
	protected void setNextNum(int i) {		
	}
	
	abstract protected void setFields(Field[] fields);
	
	@Override
	public int getData() {
		return getFields().length;
	}
	
	@Override
	public int firstField() {
		return 1;
	}
	
	@Override
	public Field getField(int i) {
		return getFields()[i];
	}
	
	@Override
	public String getQ(int q) {
		try {
			return getField(q).getQ();
		} catch (Exception e) {
			return "Error in getQ";
		}
	}
	
	@Override
	public void setQ(int i, String q) {
		try {
			getField(i).setQ(q);
		} catch (Exception e) {
		
		}
	}
	
	@Override
	public String[] getHead() {
		int n = getData() - firstField();
		String[] headlines = new String[n] ;
		for (int i=0, f=firstField(); i<n; i++, f++)
			headlines[i] = getQ(f);
		return headlines;
	}
	
	@Override
	public String get(int n) {
		try {
			return getField(n).toString();
		} catch (Exception e) {
			return e.toString();
		}
	}
	
	@Override
	public int getInt(int i) {
		Field f = getField(i);
		if (!(f instanceof IntField)) return -1;
		return ((IntField)f).getValue();
	}
	
	@Override
	public String set(int i, String s) {
		try {
			String error = getField(i).set(s.trim());
			if(error == null && i == 0) setIdNum(getIdNum());
			return getQ(i) + ": " + error;
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}
	
	@Override
	public Record clone() throws CloneNotSupportedException {
		BasicRecord nbr;
		nbr = (BasicRecord)super.clone();
		nbr.setFields(getFields().clone());
		for(int i = 0; i < getData(); i++)
			nbr.getFields()[i] = getField(i).clone();
		return nbr;
	}
	
	@Override
	public void print(OutputStream os) {
		print(new PrintWriter(os, true));
	}
	
	@Override
	public void print(PrintStream ps) {
		print(new PrintWriter(ps, true));
	}
	
	@Override
	public void print(PrintWriter pw) {
		String cut = "";
		for (int i = firstField(); i < getData(); i++) {
			pw.print(cut + get(i));
			cut = " ";
		}
		pw.println();
	}
	
	@Override
	public int register() {
		return setIdNum(getNextNum());
	}
	
	@Override
	public int getIdNum() {
		return ((IntField)(getField(0))).getValue();
	}
	
	public int setIdNum(int i) {
		IntField f = ((IntField)(getField(0)));
		f.setValue(i);
		if(i >= getNextNum()) setNextNum(i + 1);
		return f.getValue();
		
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("");
		String cut = "";
		for (int i = 0; i < getData(); i++) {
			sb.append(cut);
			sb.append(get(i));
			cut="|";
		}
		return sb.toString();
	}
	
	
	@Override
	public void parse(String l) {
		StringBuffer sb = new StringBuffer(l);
		for(int i = 0; i < getData(); i++) {
			set(i, Mjonot.erota(sb, '|'));
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if( !(obj instanceof Record)) return false;
		Record r = (Record)obj;
		for(int i = 0; i < getData(); i++) {
			if( !get(i).equals(r.get(i))) return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hc = 0;
		for(int i = 0; i < getData(); i++) {
			hc += get(i).hashCode();
		}
		return hc;
	}
}
