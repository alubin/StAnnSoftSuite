package print;

import java.awt.Color;
import java.awt.Component;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class PrintTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8725518370420949671L;
	protected final static String[] columnNames = {
		
		"\u2713",
		"FIRST NAME", 
		"LAST NAME", 
		"MIDDLE NAME", 
		"FAMILIAR NAME", 
		"Sponsor First Name", 
		"Sponsor Last Name", 
		"Sponsor", 
		"Print form", 
		"Eform/Paper", 
		"Bap Certificate", 
		"Birth Name", 
		"Date of Birth", 
		"Been Baptized?", 
		"Date of Baptism",
		"Month and Year Confirmed", 
		"Sponsor Name", 
		"Have a sponsor?",
		"Father Full Name", 
		"Mother Full Name",
		"Sacraments Desired"
		};

	public PrintTableModel(String[] col, int i) {
		super(col,i);
	}

	//	@Override
	//	public Class<?> getColumnClass(int columnIndex) {
	//		Class<?> rtnRes = null;
	//        if (columnIndex == 0) {
	//            rtnRes = Boolean.class;
	//        }
	//        else
	//        {
	//        	rtnRes = super.getColumnClass(columnIndex);
	//        }
	//		return rtnRes;
	//	}


	@Override
	public boolean isCellEditable(int row, int column) {

		return true;
	}

	public void clearRows() {
		final int rowCount = getRowCount();
		if ( rowCount > 0)
		{
			for(int i = rowCount - 1; i > -1; i--)
			{
				removeRow(i);
			}
		}

	}
}
