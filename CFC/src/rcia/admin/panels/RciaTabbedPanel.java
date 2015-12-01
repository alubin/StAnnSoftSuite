package rcia.admin.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

import database.DatabaseStore;
import database.DbResult;
import database.DbWorker;
import rcia.RciaData;

public class RciaTabbedPanel extends JPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = -8668329054778348925L;
	private ArrayList<DbResult<RciaData>> data = new ArrayList<DbResult<RciaData>>();
	private final RciaSpinner rciaSpinner;
	private final PersonalInfo pInfo;
	private final ReligiousInfo rInfo;
	private final OtherInfo oInfo;
	private final JButton saveBtn = new JButton("Save Changes");

	public RciaTabbedPanel(ArrayList<DbResult<RciaData>> arrayList)
	{
		super(new BorderLayout());
		this.data = arrayList;
		JTabbedPane tabbedPanel = new JTabbedPane();
		RciaData[] rciaList = new RciaData[arrayList.size()];
		arrayList.size();
		for (int i = 0; i < arrayList.size(); i++)
		{
			rciaList[i] = arrayList.get(i).getData();
		}
		for (int i = 0; i < arrayList.size(); i++)
		{
			rciaList[i] = arrayList.get(i).getData();
		}
		rciaSpinner = new RciaSpinner(arrayList.toArray(new DbResult[arrayList.size()]));
		pInfo = new PersonalInfo();
		rInfo = new ReligiousInfo();
		oInfo = new OtherInfo();
		tabbedPanel.addTab("Personal Info", pInfo);
		tabbedPanel.addTab("Religion Info", rInfo);
		tabbedPanel.addTab("Other Info", oInfo);

		JPanel returnPanel = new JPanel(new GridLayout(1,2));
		JSpinner dataSpinner = new JSpinner(rciaSpinner);
		JLabel userLabel = new JLabel(arrayList.size() + " returned users");
		returnPanel.add(dataSpinner);
		returnPanel.add(userLabel);

		saveBtn.addActionListener(new SaveActionListener());

		add(returnPanel, BorderLayout.NORTH);
		add(tabbedPanel);
		add(saveBtn, BorderLayout.SOUTH);
	}

	private class RciaSpinner extends SpinnerListModel
	{
		RciaData firstVal, lastVal;
		SpinnerModel linkedModel = null;

		public RciaSpinner(DbResult<RciaData>[] values)
		{
			super(values);
			firstVal = values[0].getData();
			lastVal = values[values.length -1].getData();
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

		@Override
		public Object getValue() {
			DbResult<RciaData> rtnObj = (DbResult<RciaData>) super.getValue();
			RciaData valData = (rtnObj).getData();
			pInfo.setData(rtnObj);
			rInfo.setData( rtnObj);
			oInfo.setData( rtnObj);
			saveBtn.setText("Save Changes for " + valData.getFirst() + " " + valData.getLast());
			System.out.println("Result Id = " + valData.getId());
			System.out.println("Trans Id = " + (rtnObj).getTransId());
			return rtnObj;
		}

	}

	private class SaveActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				pInfo.storeUpdates();
				rInfo.storeUpdates();
				oInfo.storeUpdates();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

	}



}
