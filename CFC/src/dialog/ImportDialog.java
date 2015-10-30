package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class ImportDialog extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField fileTxtName = new JTextField("Select File to Convert");
	String title = "Select File to Import";
	String filePath = new String();


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

		//Button to convert selected files
		JButton convertBtn = new JButton("Convert");
		convertBtn.addActionListener(new ConvertActionListener());

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
	
	public ImportDialog(String title)
	{
		this();
		this.title = title;
		((JPanel)getContentPane()).setBorder(BorderFactory.createTitledBorder(title));
	}

	private class ConvertActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Put in code that will open a file browser and convert selected file.

		}

	}

	private class CloseActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}

	}

	private class BrowseActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//File Chooser for the access File
			JFileChooser fileChooser = new JFileChooser();
			int returnVal = fileChooser.showOpenDialog(ImportDialog.this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				fileTxtName.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}

		}
	}

	public String getFilePath() {
		return filePath;
	}

}
