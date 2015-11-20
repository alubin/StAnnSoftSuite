package ccf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CCFEmailDialog extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 4957309745869936744L;
	private ArrayList<CCFData> data;
	private JComboBox<String> emailList;
	private JLabel emailDisplay;
	private JTextField emailField;
	private HashMap<String, String> emailMap;

	public CCFEmailDialog()
	{
		JButton btnSave = new JButton("Save");

		setLayout(new GridLayout(2,3));
		emailMap = new HashMap<String, String>();
		emailList = new JComboBox<String>();
		emailDisplay = new JLabel("");
		emailField = new JTextField("Email");

		add(emailList);
		add(emailDisplay);
		add(emailField);
		add(btnSave, BorderLayout.EAST);

		btnSave.addActionListener(new SaveListener());

		populateDropBox();
	}

	public CCFEmailDialog(ArrayList<CCFData> dataList)
	{
		this();
		this.data = dataList;

	}

	private void populateDropBox() {

		if(data != null)
		{
			for(CCFData data : this.data)
			{
				emailMap.put(data.getFullName(), data.getEmailAddress());
			}

			for(String fullName: emailMap.keySet())
			{
				emailList.addItem(fullName);
			}
		}
	}

	private class DropDownListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox dropDown = (JComboBox)e.getSource();
			String name = (String)dropDown.getSelectedItem();
			emailField.setText(emailMap.get(name));

		}

	}

	private class SaveListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = (String)emailList.getSelectedItem();

			if(name != null)
			{
				emailMap.put(name, emailField.getText());
			}

		}

	}



}
