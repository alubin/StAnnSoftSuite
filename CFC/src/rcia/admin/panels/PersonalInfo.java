package rcia.admin.panels;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * This panel represents the personal information of an RCIA Member
 * @author AL
 *
 */

/*
 *First
 *Last
 *Gender
 *Familiar Role
 *Birth Name
 *Address
 *City
 *State
 *Zip
 *Email
 *Phone
 *DOB
 *Age
 *Occupation
 *
 */
public class PersonalInfo extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6886588971002467357L;
	private RciaPanelItem firstNameItem = new RciaPanelItem("First");
	JPanel firstPanel = new JPanel();
	
	public PersonalInfo()
	{
		super(new GridLayout(1,1));
		add(firstNameItem);
	}

}
