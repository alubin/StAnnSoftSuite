package ccf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import custom.Convert;

public class CCFActionListener extends Convert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO: Put in code that will open a file browser and convert selected file.
		System.out.println("CCF");
		System.out.println("File Path = " + getFilePath());
		new AccessReader(getFilePath()).displayTable("Test");

	}

}
