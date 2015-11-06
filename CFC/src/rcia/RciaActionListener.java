package rcia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import custom.Convert;

public class RciaActionListener extends Convert implements ActionListener {
	private final MainFrame mainGui;
	private RciaDisplayPanel displayPanel;

	public RciaActionListener(MainFrame instance) {
		mainGui = instance;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//Convert the file for RCIA purposes.
		System.out.println("RCIA");
		System.out.println("File Path = " + getFilePath());
		ExcelReader excel = new ExcelReader(getFilePath());
		displayPanel = new RciaDisplayPanel(excel);
		displayPanel.setMainGui(mainGui);

		excel.displayTable();
		displayPanel.showPanel();

	}

}
