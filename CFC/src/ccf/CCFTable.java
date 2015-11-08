package ccf;

import java.util.ArrayList;

import javax.swing.JTable;

/**
 * This table stores the data extracted from the file and the Java Table will be used to 
 * contain the data.
 * @author AL
 *
 */
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
