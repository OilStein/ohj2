package logic;

import java.io.PrintWriter;
import java.util.Random;

import fi.jyu.mit.ohj2.Mjonot;
import interfaces.BaseRecord;
import interfaces.Field;
import interfaces.IdField;
import interfaces.IntField;
import interfaces.StringField;

public class Spell extends BaseRecord{
	
	int id;
	int spellid;
	String name;
	int school;
	int level;
	int ctime;
	int range;
	String components;
	int duration;
	
	static int nextNum = 1;
	
	public Spell() {
		super(new Field[] {
				new IdField("id", "spellid"),
				new StringField("name"),
				
				/* Nää mahdollisesti toiseen taulukkoon
				
				new IntField("school"),
				new IntField("level"),
				new IntField("ctime"),
				new IntField("range"),
				new IntField("duration"),
				
				*/
				
				new StringField("school"),
				new StringField("level"),
				new StringField("ctime"),
				new StringField("range"),
				new StringField("duration"),
				
				new StringField("components")
				
		},1);
	}
	
	
	
	public String getName() {
		return get(1);
	}
	
	public void ansFireball() {
		Random rand = new Random();
		set(1, "Fireball " + rand.nextInt());
		set(2, "1");
		set(3, "2");
		set(4, "3");
		set(5, "4");
		set(6, "5");
		set(7, "VSM");
	}
	
	
	
	 @Override
	 public void print(PrintWriter out) {
		 int l = 0;
		 for (Field f : getFields()) {
			 if(f.getQ().length() > l) {
				 l = f.getQ().length();
			 }
		 }
		 for ( Field f : getFields()) {
			 out.println(Mjonot.fmt(f.getQ(), -l -1) + ": " + f.toString());
		 }
	 }
	 
	@Override
	public Spell clone() throws CloneNotSupportedException {
		return (Spell)super.clone();
	}

}
