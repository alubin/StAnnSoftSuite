package cfc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class CFCControlPanel extends JPanel {


	private static final long serialVersionUID = 1L;
	private JMenuBar cfcMenuBar = new JMenuBar();
	private JMenu loadAccess = new JMenu("Load Access File");
	private JMenu searchDataBase = new JMenu("Search Database");


	public CFCControlPanel()
	{
		setLayout(new BorderLayout());


		cfcMenuBar.add(loadAccess);
		cfcMenuBar.add(searchDataBase);

		add(cfcMenuBar, BorderLayout.NORTH);

		loadAccess.addActionListener(new AccessDialog());
		setVisible(true);
	}

	private class AccessDialog implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Show Dialog for converting access files.

		}

	}

	private class SearchDialog implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Cause the search dialog to appear.

		}

	}

}
