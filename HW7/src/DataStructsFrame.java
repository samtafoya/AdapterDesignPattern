import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DataStructsFrame extends JFrame {
	public DataStructsFrame(String title, int[] numbers, int[] bVals) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		// compare to
		
		final ArrayList<ListItem> list = arrayToList(numbers, bVals);

		final ListPanel unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);

		JButton sortButton = new JButton("Sort List: A");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(LEFT_ALIGNMENT);
		
		JButton sortButtonB = new JButton("Sort List: B");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(RIGHT_ALIGNMENT);

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Collections.sort(list);
				orderedList.addItems(list);
				panel.add(orderedList);
				pack();
			}
		});
		
		sortButtonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Collections.sort(list, new CompareB ());
				orderedList.addItems(list);
				panel.add(orderedList);
				pack();
			}
		});

		panel.add(unorderedList);
		panel.add(sortButton);
		panel.add(sortButtonB);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private ArrayList<ListItem> arrayToList(int[] numbers, int[] bVals) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();

		for (int i = 0; i < numbers.length; i++) {
			ListItem item = new ListItem(numbers[i], bVals[i]);
			list.add(item);
		}

		return list;
	}
}
