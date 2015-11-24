package rcia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.JXTable;

import rcia.importfiles.RciaImportTableModel;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;

public class ExcelReader {

	private String fileName;

	public ExcelReader()
	{

	}
	public ExcelReader(String accessFile)
	{
		this();
		fileName = accessFile;
	}

	public static Table readTable(String fileName, String tableName) throws IOException
	{
		Table table = DatabaseBuilder.open(new File(fileName)).getTable(tableName);
		return table;
	}


	public RciaTable createTable() {
		RciaImportTableModel rciaModel = new RciaImportTableModel();
		RciaTable rciaTable = new RciaTable(new JXTable(rciaModel));
		ArrayList<ArrayList<String>> rowArray = new ArrayList<ArrayList<String>>();
		try
		{
			FileInputStream file = new FileInputStream(new File(fileName));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext())
			{
				ArrayList<String> cellArray = new ArrayList<String>();
				Row row = rowIterator.next();

				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType())
					{
					case Cell.CELL_TYPE_NUMERIC:
						if(HSSFDateUtil.isCellDateFormatted(cell))
						{
							Date date = new Date(cell.getDateCellValue().getTime());
							DateFormat formatter = new SimpleDateFormat("MM/dd/YY");
							String dateFormatted = formatter.format(date);
							cellArray.add(dateFormatted);
						}
						else
						{
							//Remove the trailing decimal point.
							cellArray.add(String.valueOf(new DecimalFormat("###").format(cell.getNumericCellValue())));
						}
						break;
					case Cell.CELL_TYPE_STRING:
						cellArray.add(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						cellArray.add(new String(" "));
						break;
					}
				}
				if(cellArray.get(0).toLowerCase().contentEquals("eform") ||
						cellArray.get(0).toLowerCase().contentEquals("paper"))
				{
					rowArray.add(cellArray);
				}
			}
			workbook.close();
			file.close();


			//The first row is removed, because it just contains the titles for the column.
			rowArray.remove(0);

			for(ArrayList<String> rowValue: rowArray)
			{
				//				System.out.println("Row = " + rowValue);
				//				System.out.println("Value 0 = "+ rowValue.get(0));
				rciaModel.addRow(rowValue.toArray());
				rciaTable.addToList(new RciaData(rowValue));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return rciaTable;

	}
}
