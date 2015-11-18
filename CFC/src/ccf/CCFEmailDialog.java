package ccf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class CCFEmailDialog {

	private ArrayList<CCFData> data;
	private JComboBox<String> emailList;
	private JTextField emailField;
	private HashMap<String, String> emailMap;

	public CCFEmailDialog(ArrayList<CCFData> dataList)
	{
		this.data = dataList;
		emailMap = new HashMap<String, String>();
		emailList = new JComboBox<String>();
		emailField = new JTextField("Email");
		JButton btnSave = new JButton("Save");

		btnSave.addActionListener(new SaveListener());

		populateDropBox();
	}

	private void populateDropBox() {

		for(CCFData data : this.data)
		{
			emailMap.put(data.getFullName(), data.getEmailAddress());
		}

		for(String fullName: emailMap.keySet())
		{
			emailList.addItem(fullName);
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
