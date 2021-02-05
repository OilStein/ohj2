package logic;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class WildMagic {

	private Spells spells = new Spells();
	private Descriptions descs = new Descriptions();
	
	public int delete(Spell spell) {
		if ( spell == null) return 0;
		int ret = spells.delete(spell.getIdNum());
		descs.deleteSpellsDesc(spell.getIdNum());
		return ret;
	} 
	
	public void deleteDescription(Description desc) {
		descs.delete(desc);
	}
	
	public void add(Spell spell) throws SailoException {
		spells.add(spell);
	}
	
	public void seekOrAdd(Spell spell) throws SailoException {
		spells.seekOrAdd(spell);
	}
	
	public void add(Description desc) throws SailoException {
		descs.seekOrAdd(desc);
	}
	
	public Collection<Spell> search(String term, int f) throws SailoException {
		return spells.find(term, f);
	}
	
	public List<Description> getDescriptions(Spell spell) throws SailoException {
		return descs.getDescriptions(spell.getIdNum());
	}
	
	public void setDescriptionEdit() {
		descs.setDelta();
	}
	
	public void setFile(String name) {
		File dir = new File(name);
		dir.mkdirs();
		String dirName = "";
		if ( !name.isEmpty() ) {
			dirName = name + "/";
			spells.setFileBaseName(dirName + "names");
			descs.setFileBaseName(dirName + "descriptions");
		}
		
	}
}
