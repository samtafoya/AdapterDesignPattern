import java.util.Comparator;

public class CompareB implements Comparator<ListItem> {
	
	// Class added so bubbles could also be sorted by b values
	@Override
	public int compare(ListItem o1, ListItem o2) {
		// TODO Auto-generated method stub
		return o2.getValB() - o1.getValB();
	}

}