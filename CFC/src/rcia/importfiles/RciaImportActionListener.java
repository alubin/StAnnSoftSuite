package rcia.importfiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rcia.ExcelReader;
import main.MainFrame;
import custom.Convert;

public class RciaImportActionListener extends Convert implements ActionListener {
	private final MainFrame mainGui;
	private RciaImportPanel displayPanel;

	public RciaImportActionListener(MainFrame instance) {
		mainGui = instance;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//Convert the file for RCIA purposes.
		System.out.println("RCIA");
		System.out.println("File Path = " + getFilePath());
		ExcelReader excel = new ExcelReader(getFilePath());
		displayPanel = new RciaImportPanel(excel);
		displayPanel.setMainGui(mainGui);
		displayPanel.saveTable();

//		displayPanel.showPanel();

	}

}
