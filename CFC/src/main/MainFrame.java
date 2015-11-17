package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import rcia.RciaAdminDialog;
import rcia.RciaImportDialog;
import ccf.CCFAdminDialog;
import ccf.CCFImportDialog;
import database.DBSetupDialog;

/**
 * This Frame will be the front facing GUI that the client will see.
 * This is where the client will navigate to other parts of the application.
 * @author AL
 *
 */
public class MainFrame extends JFrame{

	private static final long serialVersionUID = 8947518661404713452L;

	private final MainFrame instance;
	/** This menu bar for the main screen */
	private final JMenuBar optionMenuBar = new JMenuBar();
	private final JMenu fileOption = new JMenu("File");
	private final JMenu ccfOption = new JMenu("CCF");
	private final JMenu printOption = new JMenu("Print");
	private final JMenu rciaOption = new JMenu("RCIA");

	private final JMenuItem dbSetupItem = new JMenuItem("Database Setup");
	private final JMenuItem exitItem = new JMenuItem("Exit");
	private final JMenuItem ccfImport = new JMenuItem("Import CCF Data");
	private final JMenuItem rciaImport = new JMenuItem("Import RCIA Data");
	private final JMenuItem ccfAdmin = new JMenuItem("Administer CCF Data");
	private final JMenuItem rciaAdmin = new JMenuItem("Administer RCIA Data");
	private final JMenuItem printSheet = new JMenuItem("Print Sign Sheet");
	private final JMenuItem printCertificate = new JMenuItem("Print Certificate");
	
	private final CCFImportDialog ccfImportDialogBox;
	private final CCFAdminDialog ccfAdminDialogBox;
	private final RciaImportDialog rciaImportDialogBox;
	private final RciaAdminDialog rciaAdminDialogBox;

	/**
	 * This panel is responsible for displaying the appropriate values on the main screen, based on the user selections.
	 */
	static JPanel displayPanel = new JPanel();

	public MainFrame()
	{
		setTitle("St. Ann Software Suite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(1, 1));
		//		displayPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

		//Set the screen to Full Size
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		instance = this;
		
		ccfImportDialogBox = new CCFImportDialog(instance);
		ccfAdminDialogBox = new CCFAdminDialog(instance);
		rciaImportDialogBox = new RciaImportDialog(instance);
		rciaAdminDialogBox = new RciaAdminDialog(instance);

		//Populate the Menu Bar
		optionMenuBar.add(fileOption);
		optionMenuBar.add(ccfOption);
		optionMenuBar.add(rciaOption);
		optionMenuBar.add(printOption);

		//Add options to the file menu
		fileOption.add(dbSetupItem);
		fileOption.add(exitItem);

		//Add options to the ccf menu
		ccfOption.add(ccfImport);
		ccfOption.add(ccfAdmin);

		//Add options to the rcia menu
		rciaOption.add(rciaImport);
		rciaOption.add(rciaAdmin);

		//Add options to the print menu
		printOption.add(printSheet);
		printOption.add(printCertificate);


		//Add the functionality to the menu
		dbSetupItem.addActionListener(new SetupActionListener());
		exitItem.addActionListener(new ExitActionListener());

		ccfImport.addActionListener(new CCFImportActionListener());
		ccfAdmin.addActionListener(new CCFAdminActionListener());

		rciaImport.addActionListener(new RciaImportActionListener());
		rciaAdmin.addActionListener(new RciaAdminActionListener());

		printSheet.addActionListener(new PrintSheetActionListener());
		printCertificate.addActionListener(new PrintCertificateActionListener());
		
		//Adds logo to mainFrame
		JPanel panel1 = new JPanel();
	    ImageIcon logo = new ImageIcon(getClass().getResource("/images/logo.png"));
	    panel1.add(new JLabel(logo), BorderLayout.CENTER);

	    this.add(panel1);
		//Assign the menu
		setJMenuBar(optionMenuBar);
		pack();
		setVisible(true);
	}

	private class SetupActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//The Dialog box for the Database Settings
			new DBSetupDialog().setVisible(true);

		}

	}

	private class ExitActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}

	}

	public class CCFImportActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Display the dialog box for the Import window for the CCF
			//Note the instance of the JFrame is passed in so that the panel can be modified later.
			ccfImportDialogBox.setVisible(true);
		}

	}

	public class CCFAdminActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the CFC Dialog
			ccfAdminDialogBox.setVisible(true);
		}

	}

	public class PrintSheetActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Print Dialog

		}

	}

	public class PrintCertificateActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Print Dialog

		}

	}

	public class RciaImportActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Rcia Dialog
			rciaImportDialogBox.setVisible(true);

		}

	}

	public class RciaAdminActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Inquirer Dialog
			rciaAdminDialogBox.setVisible(true);

		}

	}

	//Changes the content panel of the main gui to display the panel that was passed in.
	public void setPanel(JPanel displayPnl)
	{
		getContentPane().removeAll();
		getContentPane().add(displayPnl);
		repaint();
		setVisible(true);
	}

}
