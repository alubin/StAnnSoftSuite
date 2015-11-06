package rcia;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.MainFrame;

public class RciaDisplayPanel extends JPanel {
	private MainFrame mainDisplay;

	public RciaDisplayPanel(ExcelReader excelReader)
	{
		JTable excelTable = excelReader.createTable().getTable();
		JScrollPane excelScroll = new JScrollPane(excelTable);
		JPanel btnPanel = new JPanel(new GridLayout(1,2));
		JButton btnSave = new JButton("Save");
		JButton btnCancel = new JButton("Cancel");

		excelTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


		setBorder(BorderFactory.createTitledBorder("Rcia Results"));
		setLayout(new BorderLayout());

		btnPanel.add(btnSave);
		btnPanel.add(btnCancel);

		add(btnPanel, BorderLayout.NORTH);
		add(excelScroll,BorderLayout.CENTER);
	}

	public void setMainGui(MainFrame mainGui) {
		mainDisplay = mainGui;

	}

	public void showPanel() {
		//Display this panel on the main GUI
		mainDisplay.setPanel(this);

	}

}
