package rcia;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;




public class RciaImportDialog extends JDialog {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	JTextField fileTxtName = new JTextField("Select File to Convert");


	public RciaImportDialog()
	{
		JPanel bodyPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel btnPanel = new JPanel();

		setMinimumSize(new Dimension(300, 300));
		setContentPane(bodyPanel);
		bodyPanel.setLayout(new GridLayout(5,1));
		bodyPanel.setBorder(BorderFactory.createTitledBorder("Select File"));
		bodyPanel.add(topPanel);
//		bodyPanel.add(btnPanel,BorderLayout.SOUTH);

		topPanel.setLayout(new GridLayout(2,1));

		JPanel panel = new JPanel();
		topPanel.add(panel);
		topPanel.add(btnPanel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(fileTxtName);

		//Button to browse file chooser
		JButton browseBtn = new JButton("Browse");
		panel.add(browseBtn);

		browseBtn.addActionListener(new BrowseActionListener());

		//Button to convert selected files
		JButton convertBtn = new JButton("Convert");
		convertBtn.addActionListener(new ConvertActionListener());

		//Button to close dialog box
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new CloseActionListener());

		//Layout the buttons next to each other.
		btnPanel.setLayout(new GridLayout(1,5));
		btnPanel.add(convertBtn);
		btnPanel.add(closeBtn);
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
			//			//File Chooser for the access File
			//			JFileChooser fileChooser = new JFileChooser();
			//			int returnVal = fileChooser.showOpenDialog();
			//			if(returnVal == JFileChooser.APPROVE_OPTION) {
			//				System.out.println("You chose to open this file: " +
			//						fileChooser.getSelectedFile().getName());
			//			}

		}

	}

}
