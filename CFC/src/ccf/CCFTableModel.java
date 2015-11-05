package ccf;

import javax.swing.table.DefaultTableModel;

import com.healthmarketscience.jackcess.Table;

public class CCFTableModel extends DefaultTableModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 8470548068140479664L;

	// Add "\u2713" for check symbol.
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
		super(columnNames,0);
		this.accessTable = table;
	}

//	@Override
//	public Class<?> getColumnClass(int columnIndex) {
//		System.out.println("Column Class = " + columnIndex);
//
//		return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
//	}


}
