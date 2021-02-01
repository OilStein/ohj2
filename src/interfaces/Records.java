package interfaces;

import java.util.Iterator;
import java.util.List;

import logic.SailoException;

public interface Records<TYPE extends Record> extends Iterable<TYPE> {
	
	public abstract TYPE createNew();
	
	public abstract void add(TYPE decsription);
	
	public abstract void seekOrAdd(TYPE record) throws SailoException;
	
	public abstract boolean delete(TYPE record);
	
	public abstract int delete(int id);
	
	public abstract int delete(int ref, int fieldNum);
	
	public abstract void readFile(String file) throws SailoException;
	
	public abstract void readFile() throws SailoException;
	
	public abstract void save() throws SailoException;
	
	public abstract int getTally();
	
	public abstract void setFileBaseName(String file);
	
	public abstract String getFileName();
	
	public abstract String getBackUp();
	
	@Override
	public abstract Iterator<TYPE> iterator();
	
	public abstract void setDelta();
	
	public abstract List<TYPE> getRecords(int idNum, int i);
	
	public abstract List<TYPE> find(String term, int i);
	
	public abstract TYPE getId(int id);
	
	public void clear();
	
	public void setEncoding();
}
