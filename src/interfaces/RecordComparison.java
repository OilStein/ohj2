package interfaces;

import java.util.Comparator;

public class RecordComparison implements Comparator<Record> {
	private final int fNum;
	
	public RecordComparison(int i) {
		this.fNum = i;
	}
	
	@Override
	public int compare(Record r1, Record r2) {
		if (fNum < 0) return 0;
		return r1.getField(fNum).compareTo(r2.getField(fNum));
	}
	
	
}
