package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ccf.CCFControlPanel;
import ccf.CCFImportDialog;

/**
 * This Panel will be the front facing GUI that the client will see.
 * This is where the client will navigate to other parts of the application.
 * @author AL
 *
 */
public class MainPanel extends JFrame{

	private static final long serialVersionUID = 8947518661404713452L;
	/** This menu bar for the main screen */
	JMenuBar optionMenuBar = new JMenuBar();
	JMenu ccfOption = new JMenu("CCF");
	JMenu printOption = new JMenu("Print");
	JMenu rciaOption = new JMenu("RCIA");

	JMenuItem ccfImport = new JMenuItem("Import CCF Data");
	JMenuItem rciaImport = new JMenuItem("Import RCIA Data");
	JMenuItem ccfAdmin = new JMenuItem("Administer CCF Data");
	JMenuItem rciaAdmin = new JMenuItem("Administer RCIA Data");
	JMenuItem printSheet = new JMenuItem("Print Sign Sheet");
	JMenuItem printCertificate = new JMenuItem("Print Certificate");

	/**
	 * This panel is responsible for displaying the appropriate values on the main screen, based on the user selections.
	 */
	static JPanel displayPanel = new JPanel();

	public MainPanel()
	{
		setTitle("St. Ann Software Suite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(1, 1));

		//Set the screen to Full Size
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		//Populate the Menu Bar
		optionMenuBar.add(ccfOption);
		optionMenuBar.add(rciaOption);
		optionMenuBar.add(printOption);

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
		ccfImport.addActionListener(new CCFImportActionListener());
		ccfAdmin.addActionListener(new CCFAdminActionListener());

		rciaImport.addActionListener(new RciaImportActionListener());
		rciaAdmin.addActionListener(new RciaAdminActionListener());

		printSheet.addActionListener(new PrintSheetActionListener());
		printCertificate.addActionListener(new PrintCertificateActionListener());

		//Assign the menu
		setJMenuBar(optionMenuBar);
		add(displayPanel);

		pack();
		setVisible(true);
	}

	public class CCFImportActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the CFC Dialog
//			new CCFControlPanel().setVisible(true);
			new CCFImportDialog().setVisible(true);;
		}

	}

	public class CCFAdminActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the CFC Dialog
			new CCFControlPanel().setVisible(true);
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
			// TODO Display the Inquirer Dialog

		}

	}

	public class RciaAdminActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Inquirer Dialog

		}

	}

	public static void setPanel(JPanel displayPnl)
	{
		displayPanel = displayPnl;
	}

}
