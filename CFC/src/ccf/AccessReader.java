package ccf;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.jdesktop.swingx.JXTable;

import ccf.importfiles.CCFImportTableModel;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

import custom.ErrorDialog;

/**
 * This class implements the col and functionality needed to grab information from the CCF
 * MS Access file. Given a table name this class will pull the information needed from the MS Access file
 * and format it to a format that other classes can work with.
 * @author AL
 *
 */
public class AccessReader {

	private String fileName;
	private String tableName;


	public AccessReader(String accessFile)
	{
		fileName = accessFile;
	}

	public AccessReader(String accessFile, String tableName)
	{
		fileName = accessFile;
		this.tableName = tableName;
	}

	/**
	 * This method extracts the information from the given file and adds it to a table for manipulation.
	 * @return CCFTable, an object of the extracted data.
	 */
	public CCFTable createTable()
	{
		Table table = null;
		JXTable accessTable = null;
		CCFImportTableModel tableModel;
		CCFTable tableData = null;
		try {
			table = DatabaseBuilder.open(new File(fileName)).getTable(tableName);
			tableModel = new CCFImportTableModel(table);
			accessTable = new JXTable(tableModel);
			tableData = new CCFTable(accessTable);
			for(Row row: table)
			{
				Object[] myData = row.values().toArray();
				CCFData ccfData = new CCFData(myData);
				tableData.addToList(ccfData);
				tableModel.addRow(myData);

			}

		} catch (IOException | ParseException e) {
			new ErrorDialog(e);
			e.printStackTrace();
		}

		return tableData;

	}




}
