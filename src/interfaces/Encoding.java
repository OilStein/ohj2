package interfaces;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Pattern;
import java.io.InputStreamReader;

public class Encoding {
	private String encoding = "AUTO";
	private String dEncoding = "ISO-8859-15";
	private String rEncoding = dEncoding;
	
	public Encoding() {
		
	}
	
	public Encoding(String e) {
		this.encoding = e;
	}
	
	public boolean isAuto() {
		return encoding.equalsIgnoreCase("AUTO");
	}
	
	public void setAuto() {
		encoding = "AUTO";
	}
	
	public String getEncoding() {
		if ( isAuto()) return rEncoding;
		return encoding;
	}
	
	public void setEncoding(String e) {
		this.encoding = e;
	}
	
	private final static String[] UTF8Chars = {"Ã","Ã","Ã","Ã€","Ã¶","Ã¥","Ã","ÃŒ","â¬"};
	private final static Pattern scandi = Pattern.compile(".*[ÅÄÖÜåäöü].*"); 
	
	
	public String gEncoding(String file) {
		String g = "ISO-8859-15";
		try (BufferedReader f = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "ISO-8859-1"))){
			String row;
			while ((row = f.readLine()) != null) {
				for (String s : UTF8Chars) {
					if (row.indexOf(s) >= 0) { g = "UTF-8"; break;}
					if (scandi.matcher(s).matches()) break;
				}
			}
			rEncoding = g;
			return rEncoding;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	public boolean tEncoding(String fileName) {
		if (isAuto()) {
			String g = gEncoding(fileName);
			return g != null;
		}
		return true;
	}
}
