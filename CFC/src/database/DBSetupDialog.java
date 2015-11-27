package database;

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

	JTextField ipAddressField = new JTextField(DatabaseStore.getAddress());
	JTextField portField = new JTextField(String.valueOf(DatabaseStore.getPort()));
	JTextField userField = new JTextField(DatabaseStore.getUserName());
	JTextField passField = new JTextField(String.valueOf(DatabaseStore.getPassword()));

	public DBSetupDialog()
	{
		JPanel ipAddressPanel = new JPanel(new GridLayout(2,1));
		JPanel portPanel = new JPanel(new GridLayout(2,1));
		JPanel userNamePanel = new JPanel(new GridLayout(2,1));
		JPanel passwordPanel = new JPanel(new GridLayout(2,1));
		JButton submitBtn = new JButton("Submit");
		JPanel btnPanel = new JPanel(new BorderLayout());

		setLayout(new GridLayout(6,1));
		setMinimumSize(new Dimension(300, 400));
		((JPanel)getContentPane()).setBorder(BorderFactory.createTitledBorder("Database Setup"));


		ipAddressPanel.add(new JLabel("Ip Address"));
		ipAddressPanel.add(ipAddressField);

		portPanel.add(new JLabel("Port"));
		portPanel.add(portField);
		
		userNamePanel.add(new JLabel("User Name"));
		userNamePanel.add(userField);
		
		passwordPanel.add(new JLabel("Password:"));
		passwordPanel.add(passField);
		

		
		btnPanel.add(submitBtn, BorderLayout.EAST);

		submitBtn.addActionListener(new SubmitBtnActionListener());

		add(ipAddressPanel);
		add(portPanel);
		add(userNamePanel);
		add(passwordPanel);
		add(btnPanel);

	}

	private class SubmitBtnActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			DatabaseStore.setAddress(ipAddressField.getText());
			DatabaseStore.setPort(Integer.valueOf(portField.getText()));
			DatabaseStore.setUser(userField.getText());
			DatabaseStore.setPass(passField.getText());
			setVisible(false);

		}

	}

}
