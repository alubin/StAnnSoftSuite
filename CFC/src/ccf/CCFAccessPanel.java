package ccf;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CCFAccessPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel fileLabel = new JLabel("File Name");
	JTextField fileTxtName = new JTextField("Select File to Convert");
	
	
	public CCFAccessPanel()
	{
		JPanel topPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		
		setName("Enter Access File");
		setLayout(new GridLayout(0,2));
		add(topPanel);
		add(btnPanel);
		
		
		topPanel.setLayout(new GridLayout(1, 2));
		topPanel.add(fileLabel);
		topPanel.add(fileTxtName);
		
		btnPanel.setLayout(new GridLayout(2, 1));
		JButton convertBtn = new JButton("Convert");
		convertBtn.addActionListener(new ConvertActionListener());
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new CloseActionListener());
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

}
