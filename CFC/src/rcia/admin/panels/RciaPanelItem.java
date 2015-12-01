package rcia.admin.panels;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class RciaPanelItem extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5593313896131470416L;
	private final JCheckBox selection = new JCheckBox();
	private final JLabel itemLbl = new JLabel();
	private JLabel itemDisplay = new JLabel();
	private JLabel itemTitle = new JLabel();
	private final JTextField itemInput = new JTextField();
	private final ArrayList<JComponent> compList = new ArrayList<JComponent>(4);
	private boolean selected = false;

	/**
	 * @wbp.parser.constructor
	 */
	public RciaPanelItem(String label)
	{
		itemTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		itemTitle.setLabelFor(itemInput);
		setLayout(new GridLayout(1,5));
		selection.setSelected(false);
		itemLbl.setText(label);
		//		itemDisplay.setText("N/A");
		itemInput.setText("");
		itemTitle.setText("Enter " + label);
		
		itemDisplay.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		compList.add(itemDisplay);
		compList.add(itemInput);
		compList.add(itemLbl);
		compList.add(selection);
		
		selection.addActionListener(new SelectionListener());
		
		add(selection);
		add(itemLbl);
		add(itemDisplay);
		add(itemTitle);
		add(itemInput);
	}

	public RciaPanelItem(String label, String value)
	{
		this(label);
		itemDisplay.setText(value);

	}
	
	public void setDisplayValue(String data)
	{
		itemDisplay.setText(data);
		repaint();
	}
	
	private class SelectionListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			JCheckBox valueBox = (JCheckBox)e.getSource();
			if(valueBox.isSelected())
			{
				selected = true;
				for(JComponent comp : compList)
				{
					comp.setBackground(Color.CYAN);
				}
				repaint();
			}
			else
			{
				selected = false;
				for(JComponent comp : compList)
				{
					comp.setBackground(Color.LIGHT_GRAY);
				}
				repaint();
			}
			
		}
		
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public String getNewValue()
	{
		return itemInput.getText();
	}


}
