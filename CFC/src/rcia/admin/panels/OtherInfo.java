package rcia.admin.panels;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import database.DatabaseStore;
import database.DbResult;
import database.DbWorker;
import rcia.RciaData;
import rcia.admin.UpdateDialog;

public class OtherInfo extends JPanel implements InfoPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 1320378485210346314L;

	private RciaPanelItem eform = new RciaPanelItem("Eform/Paper", "Eform_Paper");
	private RciaPanelItem badgeItem = new RciaPanelItem("Badge","Badges");
	private RciaPanelItem printItem = new RciaPanelItem("Print Form","Print_Form");
	private RciaPanelItem valueItem = new RciaPanelItem("Value","Value");
	private RciaPanelItem verificationItem = new RciaPanelItem("Verification","Verification_Form");
	private RciaPanelItem reconciliationItem = new RciaPanelItem("Reconciliation","Reconciliation");
	private RciaPanelItem bapCertItem = new RciaPanelItem("Baptism Certificate","Bap_Cert");
	private ArrayList<RciaPanelItem> itemArrayList;

	private String transID;

	private DbResult<RciaData> data;

	public OtherInfo()
	{
		super(new GridLayout(20, 1));
		itemArrayList =new ArrayList<RciaPanelItem>();

		itemArrayList.add(eform);
		itemArrayList.add(badgeItem);
		itemArrayList.add(printItem);
		itemArrayList.add(valueItem);
		itemArrayList.add(verificationItem);
		itemArrayList.add(reconciliationItem);
		itemArrayList.add(bapCertItem);

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
		this.data = dbData;
		RciaData data = dbData.getData();
		transID = dbData.getTransId();
		eform.setDisplayValue(data.getTypeOfForm());
		badgeItem.setDisplayValue(data.getBadges());
		printItem.setDisplayValue(data.getPrintForm());
		valueItem.setDisplayValue(data.getValue());
		verificationItem.setDisplayValue(data.getVerification());
		reconciliationItem.setDisplayValue(data.getReconciliation());
		bapCertItem.setDisplayValue(data.getBapCert());
	}

	@Override
	public ArrayList<RciaPanelItem> storeUpdates() throws SQLException {
		ArrayList<RciaPanelItem> itemList = new ArrayList<RciaPanelItem>();
		for(RciaPanelItem item: this.itemArrayList)
		{
			RciaPanelItem panelItem = (RciaPanelItem) item;
			if(!panelItem.getNewValue().isEmpty())
			{
				itemList.add(panelItem);
				DbWorker db = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());
				db.updateRcia(panelItem.getNewValue(), panelItem.getDbField(), transID);
				new UpdateDialog(data.getData().getFamiliarName()).setVisible(true);
			}
		}
		return itemList;
	}

}
