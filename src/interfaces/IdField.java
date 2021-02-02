package interfaces;
import java.util.HashMap;

public class IdField extends IntField{
	
	private static final HashMap<String, IntField> nextNums = new HashMap<>();
	private IntField nextNum;
	
	public IdField(String q, String id) {
		super(q);
		IntField num = nextNums.get(id);
		if(num == null) {
			num = new IntField(id);
			num.setValue(1);
		}
		nextNum = num;
		nextNums.put(id, num);
	}

	public String getId() {
		return nextNum.getQ();
	}
	
	@Override
	public void setValue(int v) {
		if ( v >= nextNum.getValue()) {
			nextNum.setValue(v);
		}
	}
	
	public int getNextNum() {
		return nextNum.getValue();
	}
	
	public int register() {
		if (getValue() != 0) return getValue();
		setValue(getNextNum());
		return getValue();
	}
}
