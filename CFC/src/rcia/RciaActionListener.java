package rcia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import custom.Convert;

public class RciaActionListener extends Convert implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		//Convert the file for RCIA purposes.
		System.out.println("RCIA");
		System.out.println("File Path = " + getFilePath());

	}

}
