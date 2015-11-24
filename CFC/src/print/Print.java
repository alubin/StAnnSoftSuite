package print;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import database.DatabaseStore;
import database.DbWorker;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;

public class Print extends JDialog {

private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	private  MainFrame mainGui;
//	private PrintDisplayPanel printDisplayPanel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;

	public Print(MainFrame mainGui) {
		setResizable(false);
		
		this.mainGui = mainGui;
		
		
		setBounds(100, 100, 300, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 11, 94, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 39, 94, 14);
		contentPane.add(lblLastName);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(88, 8, 172, 20);
		contentPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(88, 36, 172, 20);
		contentPane.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JButton searchNameBtn = new JButton("Search Name");
		searchNameBtn.setBounds(79, 67, 130, 23);
		
		contentPane.add(searchNameBtn);
		
		JPanel certTypePanel = new JPanel();
		certTypePanel.setBounds(10, 112, 188, 145);
		contentPane.add(certTypePanel);
		certTypePanel.setLayout(null);
		
		JLabel label = new JLabel("Certificate Type:");
		label.setEnabled(false);
		label.setBounds(0, 0, 139, 14);
		certTypePanel.add(label);
		
		JRadioButton radioButton = new JRadioButton("Confirmation");
		radioButton.setEnabled(false);
		radioButton.setBounds(10, 17, 109, 23);
		certTypePanel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("First Communion");
		radioButton_1.setEnabled(false);
		radioButton_1.setBounds(10, 43, 109, 23);
		certTypePanel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("Rite of Christian Initiation");
		radioButton_2.setEnabled(false);
		radioButton_2.setBounds(10, 69, 166, 23);
		certTypePanel.add(radioButton_2);
		
		JLabel label_1 = new JLabel("Print Language:");
		label_1.setEnabled(false);
		label_1.setBounds(0, 99, 89, 14);
		certTypePanel.add(label_1);
		
		JButton button = new JButton("English");
		button.setEnabled(false);
		button.setBounds(0, 122, 89, 23);
		certTypePanel.add(button);
		
		JButton button_1 = new JButton("Spanish");
		button_1.setEnabled(false);
		button_1.setBounds(99, 122, 89, 23);
		certTypePanel.add(button_1);
		
		searchNameBtn.addActionListener(new SearchNameListener());
	}
	
	private class SearchNameListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0){
			//TODO: Code to modify and create the PDF should be here.
//			try {
//				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
//						DatabaseStore.getUserName(), DatabaseStore.getPassword());

//				printDisplayPanel = new PrintDisplayPanel(mainGui);
//				printDisplayPanel.displayData(dbWorker.retrievePrintData(firstNameTextField.getText(), lastNameTextField.getText()));
				
				
//				dbWorker.dbClose();
//			} catch (SQLException e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
	}
	
}
