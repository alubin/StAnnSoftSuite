package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import custom.Convert;




public class ImportDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	JTextField fileTxtName = new JTextField("Select File to Convert");
	String title = "Select File to Import";
	StringBuilder filePath = new StringBuilder();

	/**
	 * Button to convert Selected File
	 */
	//Button was made global to allow for the reassigning of the action listener.
	JButton convertBtn = new JButton("Convert");
	private FileNameExtensionFilter filter;


	/**
	 * Default constructor that sets up all the components of the dialog.
	 */
	public ImportDialog()
	{
		JPanel topPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		//Will Be user to display file chooser
		JPanel choicePanel = new JPanel();

		setMinimumSize(new Dimension(300, 300));
		getContentPane().setLayout(new BorderLayout());
		add(topPanel);

		topPanel.setLayout(new BorderLayout(0, 0));
		topPanel.add(fileTxtName, BorderLayout.NORTH);

		topPanel.add(btnPanel, BorderLayout.SOUTH);

		//Empty Panel for now
		choicePanel.setLayout(new BorderLayout(0, 0));


		//Button Panel
		btnPanel.setLayout(new GridLayout(3, 1, 0, 0));

		//Button to close dialog box
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new CloseActionListener());


		//Button to browse file chooser
		JButton browseBtn = new JButton("Open");
		btnPanel.add(browseBtn);

		browseBtn.addActionListener(new BrowseActionListener());
		btnPanel.add(convertBtn);
		btnPanel.add(closeBtn);
	}

	/**
	 * This Constructor takes in the ActionListener that will be used for the convert button.
	 * @param title The name to be displayed for the dialog.
	 * @param convertAction The action to be taken when the convert button is pressed.
	 */
	public ImportDialog(String title, ActionListener convertAction)
	{
		this();
		this.title = title;
		((JPanel)getContentPane()).setBorder(BorderFactory.createTitledBorder(title));

		((Convert) convertAction).setFilePath(filePath);
		convertBtn.addActionListener(convertAction);
	}


	/*
	 * Action Listener for the Close Button.
	 */
	private class CloseActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}

	}

	/*
	 * Action Listener for the Open Button, this opens a file chooser for the user.
	 *
	 */
	private class BrowseActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//File Chooser for the access File
			JFileChooser fileChooser = new JFileChooser();

			//Display only Access files types when the file chooser is displayed.
//			FileNameExtensionFilter filter = new FileNameExtensionFilter(
//					"Files", "accdb", "mdb","xls","xlsx");
			fileChooser.setFileFilter(getFilter());
			fileChooser.setCurrentDirectory(new File("."));

			int returnVal = fileChooser.showOpenDialog(ImportDialog.this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				String file = fileChooser.getSelectedFile().getAbsolutePath();
				fileTxtName.setText(file);
				filePath.replace(0, filePath.length(), file);
			}

		}

	}
	
	public FileNameExtensionFilter getFilter()
	{
		return new FileNameExtensionFilter("Files", "accdb", "mdb","xls","xlsx");
	}

}
