package rcia.admin.panels;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.DatabaseStore;
import database.DbResult;
import database.DbWorker;
import rcia.RciaData;

/*
 * Sponsor First
 * Sponsor Last
 * Sponsor
 * Been Bapitized
 * DOB Baptism
 * GodParent
 * Priest Name
 * Church Name
 * Church City
 * Church State
 * Denomination Note
 * Current Parish
 * Years of Religious Education
 * Month/Year Confirmed
 * Sacrament
 * Practicing Catholic
 * Attending Sessions
 * Catholic Church
 * Catholic Convalidation Date
 * Civil Marriage Date
 * Con_A
 * Con_B
 * Con_C
 * Con_D
 * Children
 * Ages
 * Sponsor Potential
 *
 *
 */
public class ReligiousInfo extends JPanel implements InfoPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 4140864252447414202L;
	private RciaPanelItem sponFirstNameItem = new RciaPanelItem("Sponsor First","Sponsor_First_Name");
	private RciaPanelItem sponLastNameItem = new RciaPanelItem("Sponsor Last","Sponsor_Last_Name");
	private RciaPanelItem sponsorItem = new RciaPanelItem("Sponsor","Sponsor");
	private RciaPanelItem bapitizedItem = new RciaPanelItem("Been Bapitized","Been_Baptized");
	private RciaPanelItem dobBapItem = new RciaPanelItem("DOB Baptism","Date_Of_Baptism");
	private RciaPanelItem goodItem = new RciaPanelItem("God Parent Names","Godparent_Names");
	private RciaPanelItem priestItem = new RciaPanelItem("Priest Name","Priest_Name");
	private RciaPanelItem churchItem = new RciaPanelItem("Church Name","Church_Name");
	private RciaPanelItem churchCityItem = new RciaPanelItem("Church City","Church_City");
	private RciaPanelItem churchStateItem = new RciaPanelItem("Church State","Church_State");
	private RciaPanelItem denomItem = new RciaPanelItem("Denomination Note","Denomination_Note");
	private RciaPanelItem parishItem = new RciaPanelItem("Current Parish","Current_Parish");
	private RciaPanelItem yearItem = new RciaPanelItem("Year of Religious Education","Years_Of_Religious_Education");
	private RciaPanelItem monYrItem = new RciaPanelItem("Month/Year Confirmed","Month_Year_Confirmed");
	private RciaPanelItem sacramentItem = new RciaPanelItem("Sacraement","Sacraments");
	private RciaPanelItem haveSponsorItem = new RciaPanelItem("Have Sponsor","Have_Sponsor");
	private RciaPanelItem sponsorNameItem = new RciaPanelItem("Sponsor Name","Sponsor_Name");
	private RciaPanelItem sponsorPhoneItem = new RciaPanelItem("Sponsor Phone","Sponsor_Phone");
	private RciaPanelItem whySponsorItem = new RciaPanelItem("Why Sponsor","Why_Sponsor");
	private RciaPanelItem goodStanding = new RciaPanelItem("Good Standing","Good_Standing");
	private RciaPanelItem sponsorRoleItem = new RciaPanelItem("Sponsor Role","Sponsor_Role");
	private RciaPanelItem someoneItem = new RciaPanelItem("Someone in Mind","Someone_In_Mind");
	private RciaPanelItem inqNameItem = new RciaPanelItem("Inquirers_Name","Inquirers_Name");
	private RciaPanelItem inqPhoneItem = new RciaPanelItem("Inquirers Phone","Inquirers_Phone");
	private RciaPanelItem martialStatusItem = new RciaPanelItem("Martial Status","Marital_Status");
	private RciaPanelItem spouseNameItem = new RciaPanelItem("Spouse/Fiance Name","Spouse_Fiance_Name");
	private RciaPanelItem spouseRegItem = new RciaPanelItem("Spouse/Fiance Religious","Spouse_Fiance_Religious");
	private RciaPanelItem pracCathItem = new RciaPanelItem("Practicing Catholic","Practicing_Catholic");
	private RciaPanelItem attendSessItem = new RciaPanelItem("Attending Session","Attending_Sessions");
	private RciaPanelItem cathChurchItem = new RciaPanelItem("Catholic Church Name","Catholic_Church_Marriage");
	private RciaPanelItem cathConItem = new RciaPanelItem("Catholic Convalidation","Catholic_Convalidation_Date");
	private RciaPanelItem civilMarrItem = new RciaPanelItem("Civil Marriage","Civil_Marriage_Date");
	private RciaPanelItem conAItem = new RciaPanelItem("Con A","CON_A");
	private RciaPanelItem conBItem = new RciaPanelItem("Con B","CON_B");
	private RciaPanelItem conCItem = new RciaPanelItem("Con C","CON_C");
	private RciaPanelItem conDItem = new RciaPanelItem("Con D","CON_D");
	private RciaPanelItem childrenItem = new RciaPanelItem("Children","Children");
	private RciaPanelItem ageItem = new RciaPanelItem("Children Age","Ages");
	private RciaPanelItem sponPotItem = new RciaPanelItem("Sponsorship Potential","Sponsor_Potential");
	private ArrayList<RciaPanelItem> itemArrayList;
	private String transID;

	public ReligiousInfo()
	{



		super(new GridLayout(1, 1));

		JPanel religion = new JPanel(new GridLayout(35,1));
		JScrollPane scrollPanel = new JScrollPane(religion);

		itemArrayList.add(sponFirstNameItem);
		itemArrayList.add(sponLastNameItem);
		itemArrayList.add(sponsorItem);
		itemArrayList.add(bapitizedItem);
		itemArrayList.add(dobBapItem);
		itemArrayList.add(goodItem);
		itemArrayList.add(priestItem);
		itemArrayList.add(churchItem);
		itemArrayList.add(churchCityItem);
		itemArrayList.add(churchStateItem);
		itemArrayList.add(denomItem);
		itemArrayList.add(parishItem);
		itemArrayList.add(yearItem);
		itemArrayList.add(monYrItem);
		itemArrayList.add(sacramentItem);
		itemArrayList.add(haveSponsorItem);
		itemArrayList.add(sponsorNameItem);
		itemArrayList.add(sponsorPhoneItem);
		itemArrayList.add(whySponsorItem);
		itemArrayList.add(someoneItem);
		itemArrayList.add(pracCathItem);
		itemArrayList.add(attendSessItem);
		itemArrayList.add(cathChurchItem);
		itemArrayList.add(cathConItem);
		itemArrayList.add(civilMarrItem);
		itemArrayList.add(conAItem);
		itemArrayList.add(conBItem);
		itemArrayList.add(conCItem);
		itemArrayList.add(conDItem);
		itemArrayList.add(childrenItem);
		itemArrayList.add(ageItem);
		itemArrayList.add(sponPotItem);

		religion.add(sponFirstNameItem);
		religion.add(sponLastNameItem);
		religion.add(sponsorItem);
		religion.add(bapitizedItem);
		religion.add(dobBapItem);
		religion.add(goodItem);
		religion.add(priestItem);
		religion.add(churchItem);
		religion.add(churchCityItem);
		religion.add(churchStateItem);
		religion.add(denomItem);
		religion.add(parishItem);
		religion.add(yearItem);
		religion.add(monYrItem);
		religion.add(sacramentItem);
		religion.add(haveSponsorItem);
		religion.add(sponsorNameItem);
		religion.add(sponsorPhoneItem);
		religion.add(whySponsorItem);
		religion.add(someoneItem);
		religion.add(pracCathItem);
		religion.add(attendSessItem);
		religion.add(cathChurchItem);
		religion.add(cathConItem);
		religion.add(civilMarrItem);
		religion.add(conAItem);
		religion.add(conBItem);
		religion.add(conCItem);
		religion.add(conDItem);
		religion.add(childrenItem);
		religion.add(ageItem);
		religion.add(sponPotItem);
		add(scrollPanel);


	}

	public void setData(DbResult<RciaData> dbData)
	{
		RciaData valData = dbData.getData();
		transID = dbData.getTransId();
		sponFirstNameItem.setDisplayValue(valData.getSponFirst());
		sponLastNameItem.setDisplayValue(valData.getSponLast());
		sponsorItem.setDisplayValue(valData.getSponsor());
		bapitizedItem.setDisplayValue(valData.getBaptizedInChrist());
		dobBapItem.setDisplayValue(valData.getDateOfBaptism());
		goodItem.setDisplayValue(valData.getGoodStanding());
		priestItem.setDisplayValue(valData.getPriestName());
		churchItem.setDisplayValue(valData.getChurchName());
		churchCityItem.setDisplayValue(valData.getChurchCity());
		churchStateItem.setDisplayValue(valData.getChurchState());
		denomItem.setDisplayValue(valData.getDenom());
		parishItem.setDisplayValue(valData.getCurrParish());
		yearItem.setDisplayValue(valData.getYrsOfRegEd());
		monYrItem.setDisplayValue(valData.getMonthAndYear());
		sacramentItem.setDisplayValue(valData.getSacramentDesired());
		haveSponsorItem.setDisplayValue(valData.getHaveASponsor());
		sponsorNameItem.setDisplayValue(valData.getSponsorName());
		sponsorPhoneItem.setDisplayValue(valData.getSponsorNumber());
		whySponsorItem.setDisplayValue(valData.getWhySponsor());
		someoneItem.setDisplayValue(valData.getSomeoneInMind());
		pracCathItem.setDisplayValue(valData.getPracticingCatholic());
		attendSessItem.setDisplayValue(valData.getAttendSession());
		cathChurchItem.setDisplayValue(valData.getChurchName());
		cathConItem.setDisplayValue(valData.getCatholicDate());
		civilMarrItem.setDisplayValue(valData.getCivilMarriageDate());
		conAItem.setDisplayValue(valData.getConA());
		conBItem.setDisplayValue(valData.getConB());
		conCItem.setDisplayValue(valData.getConC());
		conDItem.setDisplayValue(valData.getConD());
		childrenItem.setDisplayValue(valData.getChildren());
		ageItem.setDisplayValue(valData.getAge());
		sponPotItem.setDisplayValue(valData.getSponsorPotential());

	}

	@Override
	public ArrayList<RciaPanelItem> storeUpdates() throws SQLException {
		ArrayList<RciaPanelItem> itemList = new ArrayList<RciaPanelItem>();
		for(RciaPanelItem item: this.itemArrayList)
		{
			RciaPanelItem panelItem = (RciaPanelItem) item;
			if (panelItem.isSelected())
			{
				itemList.add(panelItem);
				DbWorker db = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
						DatabaseStore.getUserName(), DatabaseStore.getPassword());
				db.updateRcia(panelItem.getNewValue(), panelItem.getDbField(), transID);
				System.out.println("Value changed = " + panelItem.getNewValue() + " for " + transID);
			}
		}
		return itemList;
	}

}
