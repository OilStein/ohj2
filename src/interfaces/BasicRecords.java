package interfaces;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import fi.jyu.mit.ohj2.WildChars;
import logic.SailoException;

public class BasicRecords<TYPE extends Record> implements Records<TYPE> {

	private boolean edit = false;
	private String fileBaseName = "";
	private TYPE mock;
	private String fileEnd = ".dat";
	private String backupfileEnd = ".bak";
	private Encoding encoding = new Encoding();
	
	private final List<TYPE> items = new ArrayList<TYPE>();
	
	public BasicRecords(TYPE mock) {
		this.mock = mock;
	}
	
	public BasicRecords(TYPE mock, String c, String bc) {
		this(mock);
		this.fileEnd = c;
		this.backupfileEnd = bc;
		
	}
	
	@SuppressWarnings({"unchecked", "null"})
	@Override
	public TYPE createNew() {
		try {
			Record n = mock.clone();
			return (TYPE)n;
		} catch (CloneNotSupportedException e) {
			return (TYPE)null;
		}
	}

	@Override
	public void add(TYPE record) {
		items.add(record);
		edit = true;
	}

	@Override
	public void seekOrAdd(TYPE record) throws SailoException {
		int id = record.getIdNum();
		for(int i = 0; i < getTally(); i++) {
			if(items.get(i).getIdNum()==id) {
				items.set(i, record);
				edit = true;
				return;
			}
		}
		add(record);
	}

	@Override
	public boolean delete(TYPE record) {
		boolean r = items.remove(record);
		if (r) edit = true;
		return r;
	}

	@Override
	public int delete(int id) {
		return delete(id, 0);
	}

	@Override
	public int delete(int ref, int fieldNum) {
		int n = 0;
		for(Iterator<TYPE> it = items.iterator(); it.hasNext();) {
			TYPE record = it.next();
			if(record.getInt(fieldNum) == ref ) {
				it.remove();
				n++;
			}
		}
		if(n>0) {
			edit = true;
		}
		return n;
	}

	@Override
	public void readFile(String file) throws SailoException {
		setFileBaseName(file);
		readFromFile(getFileName());
	}
	
	public void readFromFile(String fileName) throws SailoException{
		edit = true;
		if (!encoding.tEncoding(fileName)) {
			throw new SailoException(fileName + " not opening!");
		}
		
		try (BufferedReader file = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), getEncoding()))){
			
			String row;
			readFirstLines(file);
			while ((row = file.readLine()) != null) {
				row = row.trim();
				row = handleRow(row);
				if ( row == null) continue;
				TYPE record = createNew();
				record.parse(row);
				add(record);
			}
			edit = false;
		} catch (FileNotFoundException e) {
			throw new SailoException(fileName + " not opening!");
		} catch (UnsupportedEncodingException e) {
			edit = false;
			throw new SailoException("Encoding failure: " + getEncoding());
		}catch (IOException e) {
			throw new SailoException("Error: "+e.getMessage());
		}
	}
	
	public String handleRow(String row) {
		if (row.length() == 0 || row.charAt(0)== ';') {
			return null;
		}
		return row;
	}
	
	@Override
	public void setEncoding(String encoding) {
		this.encoding.setEncoding(encoding);
	}
	
	@Override
	public String getEncoding() {
		return encoding.getEncoding();
	}

	@Override
	public void readFile() throws SailoException {
		readFile(getFileName());
		// Maybe error;
	}
	
	protected void readFirstLines(BufferedReader file) throws IOException, SailoException {
		
	}
	
	public void baseSave(PrintWriter file) {
		
	}

	@Override
	public void save() throws SailoException {
		if (!edit) return;
		
		File file = new File(getFileName());
		if (backupfileEnd != null) {
			File fbak = new File(getBackUp());
			fbak.delete();
			file.renameTo(fbak);
		}
		
		try (PrintWriter fo = new PrintWriter(new OutputStreamWriter(
				new FileOutputStream(file.getCanonicalPath()), getEncoding()))) {
			baseSave(fo);
			for (TYPE record : this) {
				fo.println(record.toString());
			}
		} catch (FileNotFoundException e) {
			throw new SailoException(file.getName() + " fails to open!");
		} catch (IOException e) {
			throw new SailoException(file.getName() + " writing error!");
		}
		
	}

	@Override
	public int getTally() {
		return items.size();
	}

	@Override
	public void setFileBaseName(String file) {
		fileBaseName = file;
	}

	@Override
	public String getFileName() {
		return getFileBaseName() + getChecker();
	}
	
	public String getChecker() {
		return fileEnd;
	}

	@Override
	public String getBackUp() {
		return getFileBaseName() + getBackUp();
	}

	@Override
	public Iterator<TYPE> iterator() {
		return items.iterator();
	}

	@Override
	public void setDelta() {
		edit = true;
		
	}

	@Override
	public List<TYPE> getRecords(int idNum, int i) {
		List<TYPE> found = new ArrayList<TYPE>();
		for (TYPE record : this)
			if (record.getInt(i) == idNum) found.add(record);
		return found;
	}

	@Override
	public List<TYPE> find(String term, int i) {
		List<TYPE> found = new ArrayList<TYPE>();
		for ( TYPE spell : this) {
			if (WildChars.onkoSamat(spell.get(i), term)) {
				found.add(spell);
			}
		}
		Collections.sort(found, new RecordComparison(i));
		return found;
		
	}

	@Override
	public TYPE getId(int id) {
		for (TYPE record : this) {
			if(id == record.getIdNum()) return record;
		}
		return (TYPE)null;
	}

	@Override
	public void clear() {
		items.clear();
		
	}

	@Override
	public String getFileBaseName() {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}
