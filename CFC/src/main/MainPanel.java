package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import ccf.CCFControlPanel;

public class MainPanel extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 8947518661404713452L;
	JMenuBar optionMenuBar = new JMenuBar();
	JMenu ccfOption = new JMenu("CCF");
	JMenu printOption = new JMenu("Print");
	JMenu rciaOption = new JMenu("RCIA");

	JButton ccfBtn = new JButton("CCF");
	JButton printBtn = new JButton("Print");
	JButton rciaBtn = new JButton("RCIA");

	public MainPanel()
	{
		setTitle("St. Ann Software Suite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(1, 3));
//		add(optionMenuBar);
		add(new JLabel());
		add(ccfBtn);
		add(rciaBtn);
		add(printBtn);
		add(new JLabel());


		optionMenuBar.add(ccfOption);
		optionMenuBar.add(rciaOption);
		optionMenuBar.add(printOption);


		ccfBtn.addActionListener(new CCFActionListener());

		pack();
		setVisible(true);
	}

	public class CCFActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the CFC Dialog
			new CCFControlPanel().setVisible(true);
		}

	}

	public class PrintActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Print Dialog

		}

	}

	public class rciaActionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Display the Inquirer Dialog

		}

	}

}
