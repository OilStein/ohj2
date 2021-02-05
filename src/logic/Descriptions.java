package logic;

import java.util.List;

import interfaces.BasicRecords;

public class Descriptions extends BasicRecords<Description> {

	public Descriptions() {
		super(new Description());
	}
	
	public int deleteSpellsDesc(int spellid) {
		return delete(spellid, 1);
	}
	
	public List<Description> getDescriptions(int id) {
		return getRecords(id, 1);
	}
}