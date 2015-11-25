package rcia.admin.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RciaTabbedPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8668329054778348925L;

	public RciaTabbedPanel()
	{
		super(new BorderLayout());
		 JTabbedPane tabbedPanel = new JTabbedPane();
		 
		 tabbedPanel.addTab("Personal Info", new PersonalInfo());
		 tabbedPanel.addTab("Family Info", new FamilyInfo());
		 tabbedPanel.addTab("Religion Info", new ReligiousInfo());
		 tabbedPanel.addTab("Other Info", new OtherInfo());
		 
		 JButton saveBtn = new JButton("Save Changes");
		 
		 add(tabbedPanel);
		 add(saveBtn, BorderLayout.SOUTH);
	}

}
