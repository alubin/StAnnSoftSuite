package rcia.admin.panels;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

import rcia.RciaData;

public class RciaTabbedPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8668329054778348925L;
	private ArrayList<RciaData> data = new ArrayList<RciaData>();

	public RciaTabbedPanel(ArrayList<RciaData> data)
	{
		super(new BorderLayout());
		this.data = data;
		 JTabbedPane tabbedPanel = new JTabbedPane();
		 
		 tabbedPanel.addTab("Personal Info", new PersonalInfo());
		 tabbedPanel.addTab("Religion Info", new ReligiousInfo());
		 tabbedPanel.addTab("Other Info", new OtherInfo());
		 
		 JButton saveBtn = new JButton("Save Changes");
		 
		 JSpinner dataSpinner = new JSpinner(new RciaSpinner(data.toArray(new RciaData[data.size()])));
		 
		 add(dataSpinner, BorderLayout.NORTH);
		 add(tabbedPanel);
		 add(saveBtn, BorderLayout.SOUTH);
	}
	
	private class RciaSpinner extends SpinnerListModel
	{
		RciaData firstVal, lastVal;
		SpinnerModel linkedModel = null;
		
		public RciaSpinner(RciaData[] values)
		{
			super(values);
			firstVal = values[0];
			lastVal = values[values.length -1];
		}
		
	    public void setLinkedModel(SpinnerModel linkedModel) {
	        this.linkedModel = linkedModel;
	    }

	    public Object getNextValue() {
	        Object value = super.getNextValue();
	        if (value == null) {
	            value = firstVal;
	            if (linkedModel != null) {
	                linkedModel.setValue(linkedModel.getNextValue());
	            }
	        }
	        return value;
	    }

	    public Object getPreviousValue() {
	        Object value = super.getPreviousValue();
	        if (value == null) {
	            value = lastVal;
	            if (linkedModel != null) {
	                linkedModel.setValue(linkedModel.getPreviousValue());
	            }
	        }
	        return value;
	    }
	    
	}
	
	

}
