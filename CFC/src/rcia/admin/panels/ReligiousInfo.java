package rcia.admin.panels;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.DbResult;
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
	private RciaPanelItem sponFirstNameItem = new RciaPanelItem("Sponsor First");
	private RciaPanelItem sponLastNameItem = new RciaPanelItem("Sponsor Last");
	private RciaPanelItem sponsorItem = new RciaPanelItem("Sponsor");
	private RciaPanelItem bapitizedItem = new RciaPanelItem("Been Bapitized");
	private RciaPanelItem dobBapItem = new RciaPanelItem("DOB Baptism");
	private RciaPanelItem goodItem = new RciaPanelItem("God Parent");
	private RciaPanelItem priestItem = new RciaPanelItem("Priest Name");
	private RciaPanelItem churchItem = new RciaPanelItem("Church Name");
	private RciaPanelItem churchCityItem = new RciaPanelItem("Church City");
	private RciaPanelItem churchStateItem = new RciaPanelItem("Church State");
	private RciaPanelItem denomItem = new RciaPanelItem("Denomination Note");
	private RciaPanelItem parishItem = new RciaPanelItem("Current Parish");
	private RciaPanelItem yearItem = new RciaPanelItem("Year of Religious Education");
	private RciaPanelItem monYrItem = new RciaPanelItem("Month/Year Confirmed");
	private RciaPanelItem sacramentItem = new RciaPanelItem("Sacraement");
	private RciaPanelItem haveSacrementItem = new RciaPanelItem("Have Scarement");
	private RciaPanelItem sponsorNameItem = new RciaPanelItem("Sponsor Name");
	private RciaPanelItem sponsorPhoneItem = new RciaPanelItem("Sponsor Phone");
	private RciaPanelItem whySponsorItem = new RciaPanelItem("Why Sponsor");
	private RciaPanelItem someoneItem = new RciaPanelItem("Someone in Mind");
	private RciaPanelItem pracCathItem = new RciaPanelItem("Practicing Catholic");
	private RciaPanelItem attendSessItem = new RciaPanelItem("Attending Session");
	private RciaPanelItem cathChurchItem = new RciaPanelItem("Catholic Church");
	private RciaPanelItem cathConItem = new RciaPanelItem("Catholic Convalidation");
	private RciaPanelItem civilMarrItem = new RciaPanelItem("Civil Marriage");
	private RciaPanelItem conAItem = new RciaPanelItem("Con A");
	private RciaPanelItem conBItem = new RciaPanelItem("Con B");
	private RciaPanelItem conCItem = new RciaPanelItem("Con C");
	private RciaPanelItem conDItem = new RciaPanelItem("Con D");
	private RciaPanelItem childrenItem = new RciaPanelItem("Children");
	private RciaPanelItem ageItem = new RciaPanelItem("Children Age");
	private RciaPanelItem sponPotItem = new RciaPanelItem("Sponsorship Potential");
	
	public ReligiousInfo()
	{
		

		
		super(new GridLayout(1, 1));
		
		JPanel religion = new JPanel(new GridLayout(35,1));
		JScrollPane scrollPanel = new JScrollPane(religion);
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
		religion.add(haveSacrementItem);
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
		haveSacrementItem.setDisplayValue(valData.getHaveASponsor());
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
	public ArrayList<RciaPanelItem> getUpdates() {
		// TODO Auto-generated method stub
		return null;
	}

}
