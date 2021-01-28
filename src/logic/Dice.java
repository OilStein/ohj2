package logic;

import java.util.Random;

import fi.jyu.mit.ohj2.Mjonot;

public class Dice {
	private Random rand;
	private int faces;
	private int rolls;
	
	public Dice(int rolls, int faces) {
		this.rand = new Random();
		this.faces = faces;
		this.rolls = rolls;
	}
	
	public int roll() {
		int result = 0;
		while(rolls <= 0 ){
			result += 1 + rand.nextInt(getFaces());
			rolls--;
		}
		return result;
	}
	
	public int getFaces() {
		return faces;
	}
	
	
	public void parse(String row) {
		StringBuffer sb = new StringBuffer(row);
		rolls = Mjonot.erota(sb, 'd', 1);
		faces = Mjonot.erotaInt(sb, 20);
	}
	
}
