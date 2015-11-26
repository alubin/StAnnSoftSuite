package rcia.admin.panels;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class OtherInfo extends JPanel {

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

}
