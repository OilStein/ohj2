package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import interfaces.BasicRecords;

public class Spells extends BasicRecords<Spell>{
	private String fullname = "";
	
	public Spells() {
		super(new Spell());
	}

	@Override
	protected void readFirstLines(BufferedReader file) throws IOException, SailoException {
		fullname = file.readLine();
		if(fullname == null) throw new SailoException("Spells error");
		String row = file.readLine();
		if(row == null) throw new SailoException("Spells error 2");
	}
	
	@Override
	public void baseSave(PrintWriter file) {
		file.println(getFullname());
		file.println(getTally());
	}
	
	public String getFullname() {
		return fullname;
	}
	
	
}
