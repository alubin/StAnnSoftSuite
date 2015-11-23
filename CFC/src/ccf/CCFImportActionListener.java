package ccf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import custom.Convert;

/**
 * This is the Convert Button Functionality. To perform the conversion a file name is 
 * given and that information is extracted, and formatted into a Table for easy viewing, and at 
 * the same time stored in an object for easy manipulation.
 * @author AL
 *
 */
public class CCFImportActionListener extends Convert implements ActionListener {
	private final MainFrame mainGui;
	private CCFImportPanel ccfDisplay;

	public CCFImportActionListener(MainFrame instance) {
		mainGui = instance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO: Put in code that will open a file browser and convert selected file.
		ccfDisplay = new CCFImportPanel(new AccessReader(getFilePath(), "tblParishData"));
		ccfDisplay.setMainGui(mainGui);
		ccfDisplay.saveTable();

	}

}
