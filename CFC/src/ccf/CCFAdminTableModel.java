package ccf;

import javax.swing.table.DefaultTableModel;

public class CCFAdminTableModel extends DefaultTableModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 6296755378199573571L;
	protected final static String[] adminColumnNames = {"\u2713","ID", "Student ID",
		"Parish ID", "Date Of Birth",
		"Function", "Status",
		"Last Name", "First Name",
		"Full Name", "Class Offered ID",
		"Hours Credited", "Class Date",
		"Title", "Instructor", "Experience",
	"Course Level", "Email"};

	public CCFAdminTableModel(String[] col, int i) {
		super(col,i);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Class<?> rtnRes = null;
        if (columnIndex == 0) {
            rtnRes = Boolean.class;
        }
        else
        {
        	rtnRes = super.getColumnClass(columnIndex);
        }
		return rtnRes;
	}


	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return true;
	}

}
