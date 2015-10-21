package ccf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class CCFControlPanel extends JFrame {


	private static final long serialVersionUID = 1L;
	private JMenuBar ccfMenuBar = new JMenuBar();
	private JMenu loadAccess = new JMenu("Load Access File");
	private JMenu searchDataBase = new JMenu("Search Database");
	private JPanel displayPanel = new JPanel();


	public CCFControlPanel()
	{
		displayPanel.setLayout(new BorderLayout());


		ccfMenuBar.add(loadAccess);
		ccfMenuBar.add(searchDataBase);

		displayPanel.add(ccfMenuBar, BorderLayout.NORTH);

		loadAccess.addActionListener(new AccessListener());
		searchDataBase.addActionListener(new SearchListener());
		add(displayPanel);
		pack();
	}

	private class AccessListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Show Dialog for converting access files.

		}

	}

	private class SearchListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Cause the search dialog to appear.

		}

	}

}
