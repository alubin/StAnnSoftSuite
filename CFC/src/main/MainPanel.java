package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import cfc.CFCControlPanel;
import cfc.CFCDisplayPanel;

public class MainPanel extends JFrame{

	JMenuBar optionMenuBar = new JMenuBar();
	JMenu cfcOption = new JMenu("CFC");
	JMenu printOption = new JMenu("Print");
	JMenu inquirerOption = new JMenu("Inquirers");

	JButton cfcBtn = new JButton("CFC");
	JButton printBtn = new JButton("Print");
	JButton inqBtn = new JButton("Inquirer");

	public MainPanel()
	{
		setTitle("St. Ann Software Suite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(1, 3));
		add(optionMenuBar);
		add(cfcBtn);
		add(inqBtn);
		add(printBtn);


		optionMenuBar.add(cfcOption);
		optionMenuBar.add(inquirerOption);
		optionMenuBar.add(printOption);


		cfcBtn.addActionListener(new CFCActionListener());

		pack();
		setVisible(true);
	}

	public class CFCActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the CFC Dialog
			new CFCControlPanel().setVisible(true);
		}

	}

	public class PrintActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Print Dialog

		}

	}

	public class InquirerActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Inquirer Dialog

		}

	}

}
