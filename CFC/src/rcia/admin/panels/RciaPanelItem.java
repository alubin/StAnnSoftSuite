package rcia.admin.panels;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
	private JLabel itemDisplay = new JLabel();
	private final JTextField itemInput = new JTextField();

	public RciaPanelItem(String label)
	{
		setLayout(new GridLayout(1,4));
		selection.setSelected(false);
		itemLbl.setText(label);
		//		itemDisplay.setText("N/A");
		itemInput.setText("Enter " + label);
		add(selection);
		add(itemLbl);
		add(itemDisplay);
		add(itemInput);
	}

	public RciaPanelItem(String label, String value)
	{
		this(label);
		itemDisplay.setText(value);

	}


}
