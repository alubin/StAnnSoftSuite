package print;

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
import java.awt.Color;
import java.awt.Toolkit;

import java.awt.Component;
import com.toedter.calendar.JDateChooser;


public class Print extends JDialog {

private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	private  MainFrame mainGui;
//	private PrintDisplayPanel printDisplayPanel;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField pastorTextField;


	public Print(MainFrame mainGui) {
		setResizable(false);
		
		this.mainGui = mainGui;
		
		
		setBounds(100, 100, 300, 325);
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
		firstNameTextField.setBounds(88, 8, 196, 20);
		contentPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(88, 36, 196, 20);
		contentPane.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JPanel certTypePanel = new JPanel();
		certTypePanel.setBounds(10, 128, 188, 145);
		contentPane.add(certTypePanel);
		certTypePanel.setLayout(null);
		
		JLabel certTypeLabel = new JLabel("Certificate Type:");
		certTypeLabel.setBounds(0, 0, 139, 14);
		certTypePanel.add(certTypeLabel);
		
		JRadioButton confirmButton = new JRadioButton("Confirmation");
		confirmButton.setBounds(10, 17, 109, 23);
		certTypePanel.add(confirmButton);
		
		JRadioButton communionButton = new JRadioButton("First Communion");
		communionButton.setBounds(10, 43, 109, 23);
		certTypePanel.add(communionButton);
		
		JRadioButton rciaButton = new JRadioButton("Rite of Christian Initiation");
		rciaButton.setBounds(10, 69, 166, 23);
		certTypePanel.add(rciaButton);
		
		JLabel languageLabel = new JLabel("Print Language:");
		languageLabel.setBounds(0, 99, 89, 14);
		certTypePanel.add(languageLabel);
		
		JButton englishButton = new JButton("English");
		englishButton.setBounds(0, 122, 89, 23);
		certTypePanel.add(englishButton);
		
		JButton spanishButton = new JButton("Spanish");
		spanishButton.setBounds(99, 122, 89, 23);
		certTypePanel.add(spanishButton);
		
		JLabel lblPastorName = new JLabel("Pastor Name:");
		lblPastorName.setBounds(10, 67, 94, 14);
		contentPane.add(lblPastorName);
		
		pastorTextField = new JTextField();
		pastorTextField.setForeground(Color.BLACK);
		pastorTextField.setText("Fr. ");
		pastorTextField.setColumns(10);
		pastorTextField.setBounds(88, 64, 196, 20);
		contentPane.add(pastorTextField);
		
		JLabel lblConfirmationDate = new JLabel("Confirmation Date:");
		lblConfirmationDate.setBounds(10, 95, 107, 14);
		contentPane.add(lblConfirmationDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MMMM d, yyyy");
		dateChooser.setBounds(120, 95, 164, 20);
		contentPane.add(dateChooser);
		
		
		
	
	}
}
