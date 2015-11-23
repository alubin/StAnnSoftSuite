package database;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DbErrorDialog extends JDialog {

	public DbErrorDialog()
	{
		//			super("Database Error");
		setTitle("Database Error");
		setLayout(new GridLayout(3,1));
		setSize(600, 150);
		
		JLabel errorMessage = new JLabel("There was an error with the Database. "
				+ "Please Check the settings and the database.");
		JButton closeBtn = new JButton("Close");
		
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		add(errorMessage);
		add(new JLabel(""));
		add(closeBtn);
	}


}
