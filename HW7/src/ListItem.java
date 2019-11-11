import javax.swing.Icon;

public class ListItem implements Comparable<ListItem> {
	private int valA;
	private int valB;

	public ListItem(int valA, int valB) {
		this.valA = valA;
		this.valB = valB;
	}

	public int getValA() {
		return valA;
	}
	
	public int getValB() {
		return valB;
	}

	public Icon createIcon(int diameter) {
		return new ItemIcon(this, diameter);
	}

	@Override
	public int compareTo(ListItem o) {
		return o.valA - this.valA;
	}
}