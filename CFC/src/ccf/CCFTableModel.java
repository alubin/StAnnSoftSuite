package ccf;

import javax.swing.table.DefaultTableModel;

import com.healthmarketscience.jackcess.Table;

public class CCFTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8470548068140479664L;
	private final static String[] columnNames = {"ID", "Student ID",
		"Parish ID", "Date Of Birth",
		"Function", "Status",
		"Last Name", "First Name",
		"Full Name", "Class Offered ID",
		"Hours Credited", "Class Date",
		"Title", "Instructor", "Experience",
	"Course Level"};
	
	private final Table accessTable;

	public CCFTableModel(Table table)
	{
		super(columnNames, table.getRowCount());
		this.accessTable = table;
	}


	//	@Override
	//	public int getRowCount() {
	//		// TODO Auto-generated method stub
	//		return accessTable.getRowCount();
	//	}
	//
	//	@Override
	//	public int getColumnCount() {
	//		// TODO Auto-generated method stub
	//		return accessTable.getColumnCount();
	//	}
	//
	//	@Override
	//	public Object getValueAt(int rowIndex, int columnIndex) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

}
