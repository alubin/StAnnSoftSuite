package rcia.admin;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;
import rcia.RciaData;
import rcia.admin.panels.RciaTabbedPanel;
import database.DatabaseStore;
import database.DbResult;
import database.DbWorker;

import javax.swing.SwingConstants;

public class RciaAdminAdd extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = -3154004677319343553L;
	private final MainFrame mainGui;
	private RciaAdminPanel rciaAdminPanel;
	private JTextField firstTextField;
	private JTextField lastTextField;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField zipTextField;
	private JTextField phoneTextField;
	private JTextField emailTextField;

	public RciaAdminAdd(MainFrame mainGui)
	{
		setResizable(false);
		setTitle("Add New RCIA Member");
		this.mainGui = mainGui;
		setAlwaysOnTop(true);
		getContentPane().setLayout(new GridLayout(9, 2));
		
		JLabel label = new JLabel("First Name:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label);
		
		firstTextField = new JTextField(15);
		getContentPane().add(firstTextField);
		
		JLabel label_1 = new JLabel("Last Name:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label_1);
		
		lastTextField = new JTextField(15);
		getContentPane().add(lastTextField);
		
		JLabel label_2 = new JLabel("Address:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label_2);
		
		addressTextField = new JTextField(15);
		getContentPane().add(addressTextField);
		
		JLabel label_3 = new JLabel("City:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label_3);
		
		cityTextField = new JTextField(15);
		getContentPane().add(cityTextField);
		
		JLabel label_4 = new JLabel("State:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label_4);
		
		stateTextField = new JTextField(15);
		getContentPane().add(stateTextField);
		
		JLabel zipLbl = new JLabel("Zip:");
		zipLbl.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(zipLbl);
		
		zipTextField = new JTextField(15);
		getContentPane().add(zipTextField);
		
		JLabel phoneLbl = new JLabel("Phone Number:");
		phoneLbl.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(phoneLbl);
		
		phoneTextField = new JTextField(15);
		getContentPane().add(phoneTextField);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEmail);
		
		emailTextField = new JTextField(15);
		getContentPane().add(emailTextField);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JButton addNewBtn = new JButton("Add new member");
		
		
		addNewBtn.addActionListener(new AddListener());
		getContentPane().add(addNewBtn);
		setMinimumSize(new Dimension(500, 325));
		
		//add(closeBtn);

	}

	
	private class AddListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				DbWorker dbWorker = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());

				
				mainGui.setPanel(new RciaTabbedPanel(dbWorker.retrieveRciaData("", "")));

				dbWorker.dbClose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

	}

}
