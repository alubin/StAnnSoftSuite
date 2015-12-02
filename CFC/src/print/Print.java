package print;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Enumeration;

import javax.swing.JDialog;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import print.PrintCertificate;

import java.awt.Color;

import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;




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
	private JDateChooser dateChooser2;
	private String certType;
	private JRadioButton confirmButton;
	private JRadioButton communionButton;
	private JRadioButton rciaButton;
    private JButton englishButton;
    private JButton spanishButton;
    private JPanel certTypePanel;
    private JLabel warningLbl;
    private PrintCertificate printCert;

	public Print(final MainFrame mainGui) {
		setResizable(false);

		this.mainGui = mainGui;

		setAlwaysOnTop(true);

		setBounds(100, 100, 300, 380);
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
		pastorTextField.setColumns(10);
		pastorTextField.setBounds(88, 66, 196, 25);
		contentPane.add(pastorTextField);
		
		JLabel lblBaptismDate = new JLabel("Baptism Date:");
		lblBaptismDate.setBounds(10, 110, 94, 14);
		contentPane.add(lblBaptismDate);
		
		dateChooser2 = new JDateChooser();
		dateChooser2.setToolTipText("");
		dateChooser2.setDateFormatString("MMMM d, yyyy");
		dateChooser2.setBounds(115, 102, 169, 25);
		contentPane.add(dateChooser2);

		JLabel lblConfirmationDate = new JLabel("Confirmation Date:");
		lblConfirmationDate.setBounds(10, 146, 107, 14);
		contentPane.add(lblConfirmationDate);

		dateChooser = new JDateChooser();
		dateChooser.setToolTipText("");
		dateChooser.setDateFormatString("MMMM d, yyyy");
		dateChooser.setBounds(115, 141, 169, 25);
		contentPane.add(dateChooser);

		certTypePanel = new JPanel();
		certTypePanel.setBounds(10, 181, 274, 145);
		contentPane.add(certTypePanel);
		certTypePanel.setLayout(null);

		JLabel certTypeLabel = new JLabel("Certificate Type:");
		certTypeLabel.setBounds(0, 0, 139, 14);
		certTypePanel.add(certTypeLabel);

		final ButtonGroup groupType = new ButtonGroup();

		confirmButton = new JRadioButton("Confirmation");
		confirmButton.setSelected(true);
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

				if(firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("") || dateChooser2.getDate() == null || dateChooser.getDate() == null || pastorTextField.getText().equals(""))
				{
					warningLbl.setVisible(true);
				}
				else
				{
					warningLbl.setVisible(false);
					certType = getSelectedButtonText(groupType).toLowerCase().replace(" ", "_") + "_eng";

					try
					{	
						printCert = new PrintCertificate(certType, firstNameTextField.getText(), lastNameTextField.getText(), dateChooser2.getDate(), dateChooser.getDate(), pastorTextField.getText());
						if(printCert.getExists())
						{			

						 JOptionPane.showMessageDialog(mainGui, "<html>The certificate for " +
								 firstNameTextField.getText()  + " " + lastNameTextField.getText() + " was successfully created</html>");
						}
						else
						{
							JOptionPane.showMessageDialog(mainGui, "<html>The name: " + firstNameTextField.getText()  + " " + lastNameTextField.getText() + " could not be found in the database</html>", "Name Not Found", JOptionPane.WARNING_MESSAGE);
						}
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(mainGui, "<html>The certificate could not be created due to an error:<br>" + e + "</html>", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		englishButton.setBounds(0, 122, 89, 23);
		certTypePanel.add(englishButton);

		spanishButton = new JButton("Spanish");
		spanishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("") || dateChooser2.getDate() == null ||dateChooser.getDate() == null || pastorTextField.getText().equals(""))
				{
					warningLbl.setVisible(true);
				}
				else
				{
					warningLbl.setVisible(false);
					certType = getSelectedButtonText(groupType).toLowerCase().replace(" ", "_") + "_span";
					System.out.println(certType);
					try
					{
						printCert = new PrintCertificate(certType, firstNameTextField.getText(), lastNameTextField.getText(), dateChooser2.getDate(), dateChooser.getDate(), pastorTextField.getText());
						if(printCert.getExists())
						{			
						
						 JOptionPane.showMessageDialog(mainGui, "<html>The certificate for " + 
								 firstNameTextField.getText()  + " " + lastNameTextField.getText() + " was successfully created</html>");
						}
						else
						{
							JOptionPane.showMessageDialog(mainGui, "<html>The name: " + firstNameTextField.getText()  + " " + lastNameTextField.getText() + " could not be found in the database</html>", "Name Not Found", JOptionPane.WARNING_MESSAGE);
						}
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(mainGui, "<html>The certificate could not be created due to an error:<br>" + e + "</html>", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		spanishButton.setBounds(99, 122, 89, 23);
		certTypePanel.add(spanishButton);

		warningLbl = new JLabel("All fields must be filled");
		warningLbl.setVerticalAlignment(SwingConstants.TOP);
		warningLbl.setForeground(Color.RED);
		warningLbl.setBounds(10, 327, 135, 24);
		contentPane.add(warningLbl);
		
		warningLbl.setVisible(false);


	}

	//Returns String value of certificate type radio button
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
