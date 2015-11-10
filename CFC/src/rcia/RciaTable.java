package rcia;

import java.util.ArrayList;

import org.jdesktop.swingx.JXTable;

public class RciaTable {
	private JXTable table;
	private ArrayList<RciaData> rciaArray;

	public RciaTable(JXTable table)
	{
		this.table = table;
		table.packAll();
		rciaArray = new ArrayList<RciaData>(1000);
	}

	public JXTable getTable()
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
