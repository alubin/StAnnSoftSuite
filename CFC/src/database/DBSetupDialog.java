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

	DatabaseStore defaultStore = new DatabaseStore();
	JTextField ipAddressField = new JTextField(defaultStore.getSession().getAddress());
	JTextField portField = new JTextField(String.valueOf(defaultStore.getSession().getPort()));
	JTextField userField = new JTextField(defaultStore.getSession().getUserName());
	JTextField passField = new JTextField(defaultStore.getSession().getPassword());

	public DBSetupDialog()
	{
		JPanel ipAddressPanel = new JPanel(new GridLayout(2,1));
		JPanel portPanel = new JPanel(new GridLayout(2,1));
		JPanel userNamePanel = new JPanel(new GridLayout(2,1));
		JPanel passwordPanel = new JPanel(new GridLayout(2,1));
		JButton submitBtn = new JButton("Set Session");
		JPanel btnPanel = new JPanel(new BorderLayout());

		getContentPane().setLayout(new GridLayout(6,1));
		setMinimumSize(new Dimension(400, 400));
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

		getContentPane().add(ipAddressPanel);
		getContentPane().add(portPanel);
		getContentPane().add(userNamePanel);
		getContentPane().add(passwordPanel);
		getContentPane().add(btnPanel);
		
		JButton btnUseDefault = new JButton("Use Default");
		btnPanel.add(btnUseDefault, BorderLayout.WEST);
		
		btnUseDefault.addActionListener(new GetDefaultActionListener());
		
		JButton btnSetDefault = new JButton("Set Default");
		btnPanel.add(btnSetDefault, BorderLayout.CENTER);
		
		btnSetDefault.addActionListener(new SetDefaultActionListener());
		
		setAlwaysOnTop(true);

	}

	private class SubmitBtnActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			defaultStore.setAddress(ipAddressField.getText());
			defaultStore.setPort(Integer.valueOf(portField.getText()));
			defaultStore.setUser(userField.getText());
			defaultStore.setPass(passField.getText());
			DatabaseStore.setSession(defaultStore);
			updateDislplay(DatabaseStore.getSession());
//			setVisible(false);

		}

	}
	
	private class GetDefaultActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			defaultStore.useDefault();
			DatabaseStore defaultSetting = defaultStore.getSession();
			
			updateDislplay(defaultSetting);
		}
		
	}
	
	private class SetDefaultActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			defaultStore.setDefault(new DatabaseStore(ipAddressField.getText(), Integer.valueOf(portField.getText()), userField.getText(),passField.getText()));
			
		}
		
	}
	
	private void updateDislplay(DatabaseStore data)
	{
		ipAddressField.setText(data.getAddress());
		portField.setText(Integer.toString(data.getPort()));
		userField.setText(data.getUserName());
		passField.setText(data.getPassword());
		repaint();
		pack();
	}

}
