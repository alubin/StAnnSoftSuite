package ccf;

import java.util.ArrayList;

import javax.swing.JTable;

public class CCFTable {
	private final JTable table;
	private ArrayList<CCFData> ccfDataArray;

	public CCFTable(JTable table)
	{
		this.table = table;
		ccfDataArray = new ArrayList<CCFData>(1000);
	}

	public JTable getTable()
	{
		return table;
	}

	public void addToList(CCFData myData)
	{
		ccfDataArray.add(myData);
	}

	public ArrayList<CCFData> getCCFDataArrayList()
	{
		return ccfDataArray;
	}

}
