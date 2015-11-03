package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DBSetupDialog extends JDialog {

	private static final long serialVersionUID = 5582642634296508993L;

	final String ipAddress = "127.0.0.1";
	final int port = 123;
	final PreferenceManager databasePref = new PreferenceManager();

	public DBSetupDialog()
	{
		JPanel ipAddressPanel = new JPanel();
		JPanel portPanel = new JPanel();
		JButton submitBtn = new JButton("Submit");

		setLayout(new GridLayout(5,1));
		setMinimumSize(new Dimension(300, 300));
		((JPanel)getContentPane()).setBorder(BorderFactory.createTitledBorder("Database Setup"));


		ipAddressPanel.setLayout(new GridLayout(2, 2));
		portPanel.setLayout(new GridLayout(2,2));

		ipAddressPanel.add(new JLabel("Ip Address"));
		ipAddressPanel.add(new JTextField(ipAddress));

		portPanel.add(new JLabel("Port"));
		portPanel.add(new JTextField(String.valueOf(port)));

		JPanel btnPanel = new JPanel(new BorderLayout());
		btnPanel.add(submitBtn, BorderLayout.EAST);

		submitBtn.addActionListener(new SubmitBtnActionListener());

		add(ipAddressPanel);
		add(portPanel);
		add(btnPanel);

	}

	private class SubmitBtnActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			databasePref.setDatabaseSettings(ipAddress, port);

		}

	}

}
