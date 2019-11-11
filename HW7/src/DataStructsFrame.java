import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		
		// text field and btn for adding additional data
		final JTextField newData = new JTextField("Add data using x, y format");
		newData.setSize(30, 10);
		newData.setAlignmentY(TOP_ALIGNMENT);
		
		JButton addData = new JButton("Add Data");
		addData.setSize(30, 10);
		addData.setAlignmentY(TOP_ALIGNMENT);
		addData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String text = newData.getText().toString();
				String[] str = text.split(",");
				panel.remove(unorderedList);
				ListItem item = new ListItem(Integer.parseInt(str[0].trim()), Integer.parseInt(str[1].trim()));
				list.add(item);
				unorderedList.addItems(list);
				panel.add(unorderedList);
			}
		});
		
		// new button added so list can be sorted by B values
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
		panel.add(addData);
		panel.add(newData);
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
