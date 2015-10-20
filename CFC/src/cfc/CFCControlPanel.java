package cfc;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class CFCControlPanel extends JPanel {
	
	JMenuBar cfcMenuBar = new JMenuBar();
	JMenu loadAccess = new JMenu("Load Access File");
	JMenu searchDataBase = new JMenu("Search Database");
	
	
	public CFCControlPanel()
	{
		setLayout(new BorderLayout());
		add(cfcMenuBar, BorderLayout.NORTH);
		
		cfcMenuBar.add(loadAccess);
		cfcMenuBar.add(searchDataBase);
	}

}
