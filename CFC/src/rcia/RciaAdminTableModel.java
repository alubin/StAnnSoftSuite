package rcia;

import javax.swing.table.DefaultTableModel;

public class RciaAdminTableModel extends DefaultTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8725518370420949671L;
	protected final static String[] columnNames = {
		"\u2713",
		"Eform//paper",
		"Badges",
		"print form",
		"121.0",
		"Verification Form",
		"Reconciliation",
		"Bap Certificate",
		"Birth Certificate",
		"Saint",
		"Gender",
		"ROLESt",
		"LAST NAME",
		"FAMILIAR NAME",
		"Sponsor First Name",
		"Sponsor Last Name",
		"Sponsor",
		"FIRST NAME",
		"MIDDLE NAME",
		"BIRTH NAME",
		"ADDRESS",
		"CITY",
		"STATE",
		"ZIP",
		"EMAIL ADDRESS",
		"MAIN PHONE CONTACT",
		"DATE OF BIRTH",
		"AGE",
		"OCCUPATION",
		"BIRTHPLACE CITY",
		"BIRTHPLACE STATE",
		"FULL NAME OF YOUR FATHER",
		"FULL NAME OF YOUR MOTHER",
		"HAVE YOU BEEN BAPTIZED IN A CHRISTIAN DENOMINATION?",
		"DATE OF BAPTISM",
		"GODPARENT NAME(S)",
		"PRIEST/MINISTER'S NAME",
		"CHURCH NAME",
		"CHURCH CITY",
		"CHURCH STATE",
		"Denomination Note: Previously baptized Inquirers",
		"CURRENT PARISH",
		"YEARS OF RELIGIOUS EDUCATION",
		"MONTH AND YEAR CONFIRMED (SP/AU)",
		"WHICH SACRAMENTS DO YOU DESIRE TO CELEBRATE IN THE CATHOLIC CHURCH?",
		"DO YOU HAVE A SPONSOR?",
		"SPONSOR'S NAME",
		"SPONSOR'S PHONE NUMBER",
		"WHY DO YOU FEEL CALLED TO SERVE AS A SPONSOR?",
		"GOOD STANDING",
		"Sponsor ROLE",
		"DO YOU HAVE SOMEONE IN MIND?",
		"INQUIRER'S NAME",
		"INQUIRER'S PHONE NUMBER",
		"MARITAL STATUS",
		"SPOUSE'S/ FIANCE'S NAME",
		"SPOUSE'S / FIANC�'S RELIGIOUS AFFILIATION",
		"PRACTICING CATHOLIC",
		"ATTENDING SESSIONS",
		"CATHOLIC CHURCH MARRIAGE CEREMONY DATE",
		"CATHOLIC CONVALIDATION DATE",
		"CIVIL MARRIAGE CEREMONY DATE",
		"CON. A",
		"CON. B",
		"CON. C",
		"CON. D",
		"CHILDREN",
		"AGES",
	"If needed, would you consider the role of a Sponsor?"};
	
	public RciaAdminTableModel(String[] col, int i) {
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
