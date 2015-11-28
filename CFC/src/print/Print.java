package print;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainFrame;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import database.DatabaseStore;
import database.DbWorker;

import print.PrintCertificate;

import java.awt.Color;
import java.awt.Toolkit;

import java.awt.Component;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;


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
	private JDateChooser dateChooser;
	private String certType;
	private JRadioButton confirmButton;
	private JRadioButton communionButton;
	private JRadioButton rciaButton;
    private JButton englishButton;
    private JButton spanishButton;
    private PrintCertificate printCert;

	public Print(MainFrame mainGui) {
		setResizable(false);
		
		this.mainGui = mainGui;
		
		setAlwaysOnTop(true);
		
		setBounds(100, 100, 300, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 13, 94, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 41, 94, 14);
		contentPane.add(lblLastName);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(88, 8, 196, 25);
		contentPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(88, 36, 196, 25);
		contentPane.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		
		JLabel lblPastorName = new JLabel("Pastor Name:");
		lblPastorName.setBounds(10, 72, 94, 14);
		contentPane.add(lblPastorName);
		
		pastorTextField = new JTextField();
		pastorTextField.setForeground(Color.BLACK);
		pastorTextField.setText("Fr. ");
		pastorTextField.setColumns(10);
		pastorTextField.setBounds(88, 66, 196, 25);
		contentPane.add(pastorTextField);
		
		JLabel lblConfirmationDate = new JLabel("Confirmation Date:");
		lblConfirmationDate.setBounds(10, 109, 107, 14);
		contentPane.add(lblConfirmationDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MMMM d, yyyy");
		dateChooser.setBounds(120, 102, 164, 25);
		contentPane.add(dateChooser);
		
		JPanel certTypePanel = new JPanel();
		certTypePanel.setBounds(10, 150, 274, 145);
		contentPane.add(certTypePanel);
		certTypePanel.setLayout(null);
		
		JLabel certTypeLabel = new JLabel("Certificate Type:");
		certTypeLabel.setBounds(0, 0, 139, 14);
		certTypePanel.add(certTypeLabel);
		
		ButtonGroup groupType = new ButtonGroup();
		
		confirmButton = new JRadioButton("Confirmation");
		confirmButton.setBounds(10, 17, 226, 23);
		certTypePanel.add(confirmButton);
		
		communionButton = new JRadioButton("First Communion");
		communionButton.setBounds(10, 43, 226, 23);
		certTypePanel.add(communionButton);
		
		rciaButton = new JRadioButton("Rite of Christian Initiation");
		rciaButton.setBounds(10, 69, 226, 23);
		certTypePanel.add(rciaButton);
		
		
		groupType.add(confirmButton);
		groupType.add(communionButton);
		groupType.add(rciaButton);
		
		JLabel languageLabel = new JLabel("Print Language:");
		languageLabel.setBounds(0, 99, 155, 14);
		certTypePanel.add(languageLabel);
		
		
		englishButton = new JButton("English");
		englishButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				certType = getSelectedButtonText(groupType).toLowerCase().replace(" ", "_") + "_eng";
				System.out.println(certType);
				
				printCert = new PrintCertificate(certType, firstNameTextField.getText(), lastNameTextField.getText(), dateChooser.getDate().toString(), pastorTextField.getText());
			}
		});
		englishButton.setBounds(0, 122, 89, 23);
		certTypePanel.add(englishButton);
		
		spanishButton = new JButton("Spanish");
		spanishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				certType = getSelectedButtonText(groupType).toLowerCase().replace(" ", "_") + "_span";
				System.out.println(certType);
				printCert = new PrintCertificate(certType, firstNameTextField.getText(), lastNameTextField.getText(), dateChooser.getDate().toString(), pastorTextField.getText());
			}
		});
		spanishButton.setBounds(99, 122, 89, 23);
		certTypePanel.add(spanishButton);
		
		
	}
	
	 public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return null;
	    }
	
	
}
