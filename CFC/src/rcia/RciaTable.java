package rcia;

import java.util.ArrayList;

import javax.swing.JTable;

public class RciaTable {
	private JTable table;
	private ArrayList<RciaData> rciaArray;

	public RciaTable(JTable table)
	{
		this.table = table;
		rciaArray = new ArrayList<RciaData>(1000);
	}

	public JTable getTable()
	{
		return table;
	}

	public void addToList(RciaData rciaData)
	{
		rciaArray.add(rciaData);
	}

	public ArrayList<RciaData> getRciaDataArrayList() {
		return rciaArray;
	}
}
