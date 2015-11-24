package rcia.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import rcia.ExcelReader;
import rcia.importfiles.RciaImportPanel;
import main.MainFrame;
import custom.Convert;

public class RciaActionListener extends Convert implements ActionListener {
	private final MainFrame mainGui;
	private RciaImportPanel displayPanel;

	public RciaActionListener(MainFrame instance) {
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

		displayPanel.showPanel();

	}

}
