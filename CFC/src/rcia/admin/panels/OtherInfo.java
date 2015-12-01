package rcia.admin.panels;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import database.DbResult;
import rcia.RciaData;

public class OtherInfo extends JPanel implements InfoPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1320378485210346314L;
	
	private RciaPanelItem eform = new RciaPanelItem("Eform/Paper");
	private RciaPanelItem badgeItem = new RciaPanelItem("Badge");
	private RciaPanelItem printItem = new RciaPanelItem("Print Form");
	private RciaPanelItem valueItem = new RciaPanelItem("Value");
	private RciaPanelItem verificationItem = new RciaPanelItem("Verification");
	private RciaPanelItem reconciliationItem = new RciaPanelItem("Reconciliation");
	private RciaPanelItem bapCertItem = new RciaPanelItem("Baptism Certificate");
	
	public OtherInfo()
	{
		super(new GridLayout(20, 1));
		add(eform);
		add(badgeItem);
		add(printItem);
		add(valueItem);
		add(verificationItem);
		add(reconciliationItem);
		add(bapCertItem);
	}
	
	public void setData(DbResult<RciaData> dbData)
	{
		RciaData data = dbData.getData();
		eform.setDisplayValue(data.getTypeOfForm());
		badgeItem.setDisplayValue(data.getBadges());
		printItem.setDisplayValue(data.getPrintForm());
		valueItem.setDisplayValue(data.getValue());
		verificationItem.setDisplayValue(data.getVerification());
		reconciliationItem.setDisplayValue(data.getReconciliation());
		bapCertItem.setDisplayValue(data.getBapCert());
	}

	@Override
	public ArrayList<RciaPanelItem> getUpdates() {
		// TODO Auto-generated method stub
		return null;
	}

}
