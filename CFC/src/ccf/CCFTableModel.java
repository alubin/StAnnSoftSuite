package ccf;

import javax.swing.table.AbstractTableModel;

import com.healthmarketscience.jackcess.Table;

public class CCFTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8470548068140479664L;
	Table accessTable;
	
	public CCFTableModel(Table table)
	{
		this.accessTable = table;
	}
	
	@Override
	public String getColumnName(int column) 
	{
		String[] columnNames = {"ID", "Student ID",
				"Parish ID", "Date Of Birth",
				"Function", "Status",
				"Last Name", "First Name",
				"Full Name", "Class Offered ID",
				"Hours Credited", "Class Date",
				"Title", "Instructor", "Experience",
				"Course Level"};
		return columnNames[column].toString();
	};
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return accessTable.getRowCount();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return accessTable.getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
