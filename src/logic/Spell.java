package logic;

import java.util.Random;
import logic.School;

public class Spell {
	
	//int id;
	int spellid;
	String name;
	int school;
	int level;
	int ctime;
	int range;
	String components;
	int duration;
	
	static int nextNum = 1;
	
	
	
	public String getName() {
		return name;
	}
	
	public void ansFireball() {
		Random rand = new Random();
		name = "Fireball" + rand.nextInt();
		school = 4;
		level = 3;
		ctime = 1;
		range = 4;
		components = "VSM Firebat";
		duration = 1;
	}
	
	public void setSpellid(int num) {
		spellid = nextNum;
		if (spellid >= nextNum) nextNum = spellid + 1;
	}
	
	public int getSpellid() {
		return spellid;
	}
	
	 @Override
	 public String toString() {
		 return "" +
				 // getId() + "|" +
				 getSpellid() + "|" +
				 name + "|" +
				 //getSchool() + "|" +
				 level + "|" +
				 //getCtime() + "|" +
				 //getRange() + "|" +
				 components + "|" 
				 //getDuration()
				 ;
	 }

}
