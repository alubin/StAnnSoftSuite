package ccf;

import java.io.File;
import java.io.IOException;

import javax.swing.JTable;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

public class AccessReader {

	private String fileName;
	private String tableName;

	public AccessReader()
	{

	}
	public AccessReader(String accessFile)
	{
		this();
		fileName = accessFile;
	}
	
	public AccessReader(String accessFile, String tableName)
	{
		this();
		fileName = accessFile;
		this.tableName = tableName;
	}

	public static Table readTable(String fileName, String tableName) throws IOException
	{
		Table table = DatabaseBuilder.open(new File(fileName)).getTable(tableName);
		return table;
	}


	public void displayTable(String tableName) {
		try {
			Table table = DatabaseBuilder.open(new File(fileName)).getTable(tableName);
			for(Row row : table)
			{
				System.out.println("Key Collection" + row.keySet());
				System.out.println("Value Collection" + row.values());

				System.out.println(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	
	
	public JTable createTable()
	{
		Table table = null;
		JTable accessTable = null;
		try {
			table = DatabaseBuilder.open(new File(fileName)).getTable(tableName);
			accessTable = new JTable(new CCFTableModel(table));
			System.out.println("Row Count = " + table.getRowCount());
			System.out.println("Columns Count = " + table.getColumnCount());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (accessTable);
		
	}




}
