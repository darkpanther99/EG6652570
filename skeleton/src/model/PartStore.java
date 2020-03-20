package model;

public class PartStore {
	private int count = 0;
	public void Gain(int n) {
		this.setCount(this.getCount() + n);
	}
	
	public void Gain(PartStore ps) {
		if(ps != this) {
			this.Gain(ps.getCount());
			ps.setCount(0);
		}
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
}
