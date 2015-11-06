package rcia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JTable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;

public class ExcelReader {

	private String fileName;
	private String tableName;

	public ExcelReader()
	{

	}
	public ExcelReader(String accessFile)
	{
		this();
		fileName = accessFile;
	}

	public ExcelReader(String accessFile, String tableName)
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


	public void displayTable() {
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
                            System.out.print(cell.getNumericCellValue() + "t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "t");
                            break;
                    }
                    System.out.println("");
                }
                System.out.println("\n");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


	}


//	public RciaTable createTable()
//	{
//		Table table = null;
//		JTable accessTable = null;
//		CCFTableModel tableModel;
//		CCFTable tableData = null;
//		try {
//			table = DatabaseBuilder.open(new File(fileName)).getTable(tableName);
//			tableModel = new CCFTableModel(table);
//			accessTable = new JTable(tableModel);
//			tableData = new CCFTable(accessTable);
//			for(Row row: table)
//			{
//				Object[] myData = row.values().toArray();
//				CCFData ccfData = new CCFData(myData);
//				tableData.addToList(ccfData);
//				tableModel.addRow(myData);
////				System.out.println("Value Collection" + row.values());
////				System.out.println("CCF Data = " + ccfData);
//
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return tableData;
//
//	}




}
