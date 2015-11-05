package ccf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import custom.Convert;

public class CCFActionListener extends Convert implements ActionListener {
	MainFrame mainGui;

	public CCFActionListener(MainFrame instance) {
		mainGui = instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO: Put in code that will open a file browser and convert selected file.
		new CCFDisplayPanel(new AccessReader(getFilePath(), "tblParishData")).displayPanel(mainGui);

	}

}
