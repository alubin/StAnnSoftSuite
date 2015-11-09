package ccf;

import javax.swing.table.DefaultTableModel;

import com.healthmarketscience.jackcess.Table;

/**
 * This is the custom table model for the CCF Table.
 * @author AL
 *
 */
public class CCFTableModel extends DefaultTableModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 8470548068140479664L;

	// Add "\u2713" for check symbol.
	protected final static String[] columnNames = {"ID", "Student ID",
		"Parish ID", "Date Of Birth",
		"Function", "Status",
		"Last Name", "First Name",
		"Full Name", "Class Offered ID",
		"Hours Credited", "Class Date",
		"Title", "Instructor", "Experience",
	"Course Level"};

	protected final static String[] adminColumnNames = {"\u2713","ID", "Student ID",
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

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}


}
