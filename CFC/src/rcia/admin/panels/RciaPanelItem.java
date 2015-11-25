package rcia.admin.panels;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RciaPanelItem extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5593313896131470416L;
	private final JCheckBox selection = new JCheckBox();
	private final JLabel itemLbl = new JLabel();
	private final JTextField itemInput = new JTextField();
	
	public RciaPanelItem(String label)
	{
		setLayout(new GridLayout(1,4));
		selection.setSelected(false);
		itemLbl.setText(label);
		itemInput.setText("Enter " + label);
	}
	

}
