package ccf;

import java.io.File;
import java.io.IOException;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

public class AccessReader {

	private String fileName;

	public AccessReader()
	{

	}
	public AccessReader(String accessFile)
	{
		this();
		fileName = accessFile;
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




}
