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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class RciaPanelItem extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 5593313896131470416L;
	private final JLabel itemLbl = new JLabel();
	private JLabel itemDisplay = new JLabel();
	private JLabel itemTitle = new JLabel();
	private final JTextField itemInput = new JTextField();
	private final ArrayList<JComponent> compList = new ArrayList<JComponent>(4);
	private final String dbField;

	/**
	 * @wbp.parser.constructor
	 */
	public RciaPanelItem(String label, String dbField)
	{
		this.dbField = dbField;
		itemTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		itemTitle.setLabelFor(itemInput);
		setLayout(new GridLayout(1,5));
		itemLbl.setText(label);
		//		itemDisplay.setText("N/A");
//		itemInput.setText("");
		itemInput.getDocument().addDocumentListener(new ValueDocListener());
		itemTitle.setText("Enter " + label);

		itemDisplay.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		compList.add(itemDisplay);
		compList.add(itemInput);
		compList.add(itemLbl);


		add(itemLbl);
		add(itemDisplay);
		add(itemTitle);
		add(itemInput);
	}

	public void setDisplayValue(String data)
	{
		itemDisplay.setText(data);
		repaint();
	}
	
	private class ValueDocListener implements DocumentListener
	{

		@Override
		public void insertUpdate(DocumentEvent e) {
			checkValue();
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			checkValue();
			
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			checkValue();
			
		}
		
	}
	
	private void checkValue()
	{
		if(itemInput.getText().isEmpty())
		{
			itemInput.setBackground(Color.WHITE);
		}
		else
		{
			itemInput.setBackground(Color.CYAN);
		}
	}


	public String getNewValue()
	{
		return itemInput.getText();
	}

	public String getDbField()
	{
		return dbField;
	}
	
	public String getPrevValue()
	{
		return itemDisplay.getText();
	}


}
