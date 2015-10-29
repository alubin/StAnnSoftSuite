package ccf;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

public class CCFImportPanel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel fileLabel = new JLabel("File Name");
	JTextField fileTxtName = new JTextField("Select File to Convert");


	public CCFImportPanel()
	{
		JPanel topPanel = new JPanel();
		JPanel btnPanel = new JPanel();

		setMinimumSize(new Dimension(300, 300));
		setName("Enter Access File");
		setLayout(new GridLayout(2,1));
		add(topPanel);
		add(btnPanel);

		topPanel.setLayout(new GridLayout(2, 1));
		topPanel.add(fileLabel);

		JPanel panel = new JPanel();
		topPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.add(fileTxtName);


		JButton browseBtn = new JButton("Browse");
		panel.add(browseBtn);
		browseBtn.addActionListener(new BrowseActionListener());
		JButton convertBtn = new JButton("Convert");
		convertBtn.setHorizontalAlignment(SwingConstants.LEFT);
		convertBtn.addActionListener(new ConvertActionListener());
		JButton closeBtn = new JButton("Close");
		closeBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		closeBtn.addActionListener(new CloseActionListener());
		btnPanel.setLayout(new GridLayout(1,2));
		btnPanel.add(convertBtn, BorderLayout.CENTER);
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
