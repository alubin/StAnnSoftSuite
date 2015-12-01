package rcia.admin.panels;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.DbResult;
import rcia.RciaData;

/**
 * This panel represents the personal information of an RCIA Member
 * @author AL
 *
 */

/*
 *First
 *Last
 *Gender
 *Familiar Name
 *Role
 *Birth Name
 *Address
 *City
 *State
 *Zip
 *Email
 *Phone
 *DOB
 *Age
 *Occupation
 *Saint
 *Birth Place City
 *Birth Place State
 *Birth Certificate
 *Baptism Certificate
 *Father Full Name
 *Mother Full Name
 *God Father Name
 *Spouse Fiance Name
 *Spouse Fiance Religion
 */
public class PersonalInfo extends JPanel implements InfoPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6886588971002467357L;
	private RciaPanelItem firstNameItem = new RciaPanelItem("First");
	private RciaPanelItem lastNameItem = new RciaPanelItem("Last");
	private RciaPanelItem genderItem = new RciaPanelItem("Gender");
	private RciaPanelItem familiarNameItem = new RciaPanelItem("Familiar Name");
	private RciaPanelItem roleNameItem = new RciaPanelItem("Role");
	private RciaPanelItem birthNameItem = new RciaPanelItem("Birth Name");
	private RciaPanelItem addressItem = new RciaPanelItem("Address");
	private RciaPanelItem cityItem = new RciaPanelItem("City");
	private RciaPanelItem stateItem = new RciaPanelItem("State");
	private RciaPanelItem zipItem = new RciaPanelItem("Zip");
	private RciaPanelItem emailItem = new RciaPanelItem("Email");
	private RciaPanelItem phoneItem = new RciaPanelItem("Phone");
	private RciaPanelItem dobItem = new RciaPanelItem("DOB");
	private RciaPanelItem ageItem = new RciaPanelItem("Age");
	private RciaPanelItem occupationItem = new RciaPanelItem("Occupation");
	private RciaPanelItem saintItem = new RciaPanelItem("Saint");
	private RciaPanelItem bpCityItem = new RciaPanelItem("Birth Place City");
	private RciaPanelItem bpStateItem = new RciaPanelItem("Birth Place State");
	private RciaPanelItem birthCertItem = new RciaPanelItem("Birth Certificate");
	private RciaPanelItem bapCertItem = new RciaPanelItem("Baptism Certificate");
	private RciaPanelItem fatherItem = new RciaPanelItem("Father Full Name");
	private RciaPanelItem motherItem = new RciaPanelItem("Mother Full Name");
	private RciaPanelItem godParentItem = new RciaPanelItem("God Father Name");
	private ArrayList<RciaPanelItem> itemArrayList;
	private String transID;
	
	public PersonalInfo()
	{
		super(new GridLayout(1,1));
		JPanel personal = new JPanel(new GridLayout(23,1));
		JScrollPane scrollPanel = new JScrollPane(personal);
		itemArrayList =new ArrayList<RciaPanelItem>();
		
		itemArrayList.add(firstNameItem);
		itemArrayList.add(lastNameItem);
		itemArrayList.add(genderItem);
		itemArrayList.add(familiarNameItem);
		itemArrayList.add(roleNameItem);
		itemArrayList.add(birthNameItem);
		itemArrayList.add(addressItem);
		itemArrayList.add(cityItem);
		itemArrayList.add(stateItem);
		itemArrayList.add(zipItem);
		itemArrayList.add(emailItem);
		itemArrayList.add(phoneItem);
		itemArrayList.add(dobItem);
		itemArrayList.add(ageItem);
		itemArrayList.add(occupationItem);
		itemArrayList.add(saintItem);
		itemArrayList.add(bpCityItem);
		itemArrayList.add(bpStateItem);
		itemArrayList.add(birthCertItem);
		itemArrayList.add(bapCertItem);
		itemArrayList.add(fatherItem);
		itemArrayList.add(motherItem);
		itemArrayList.add(godParentItem);
		
		personal.add(firstNameItem);
		personal.add(lastNameItem);
		personal.add(genderItem);
		personal.add(familiarNameItem);
		personal.add(roleNameItem);
		personal.add(birthNameItem);
		personal.add(addressItem);
		personal.add(cityItem);
		personal.add(stateItem);
		personal.add(zipItem);
		personal.add(emailItem);
		personal.add(phoneItem);
		personal.add(dobItem);
		personal.add(ageItem);
		personal.add(occupationItem);
		personal.add(saintItem);
		personal.add(bpCityItem);
		personal.add(bpStateItem);
		personal.add(birthCertItem);
		personal.add(bapCertItem);
		personal.add(fatherItem);
		personal.add(motherItem);
		personal.add(godParentItem);
		
		add(scrollPanel);
	}
	
	public void setData(DbResult<RciaData> dbData)
	{
		RciaData data = dbData.getData();
		transID = dbData.getTransId();
		firstNameItem.setDisplayValue(data.getFirst());
		lastNameItem.setDisplayValue(data.getLastName());
		genderItem.setDisplayValue(data.getGender());
		familiarNameItem.setDisplayValue(data.getFamiliarName());
		roleNameItem.setDisplayValue(data.getRole());
		birthNameItem.setDisplayValue(data.getBirthName());
		addressItem.setDisplayValue(data.getAddress());
		cityItem.setDisplayValue(data.getCity());
		stateItem.setDisplayValue(data.getState());
		zipItem.setDisplayValue(data.getZip());
		emailItem.setDisplayValue(data.getEmailAddress());
		phoneItem.setDisplayValue(data.getPhoneNumber());
		dobItem.setDisplayValue(data.getDob());
		ageItem.setDisplayValue(data.getOccupation());
		saintItem.setDisplayValue(data.getSaintName());
		bpCityItem.setDisplayValue(data.getBirthplaceCity());
		bpStateItem.setDisplayValue(data.getBpState());
		birthCertItem.setDisplayValue(data.getBirthCert());
		bapCertItem.setDisplayValue(data.getBapCert());
		fatherItem.setDisplayValue(data.getFatherFullName());
		motherItem.setDisplayValue(data.getMotherFullName());
		godParentItem.setDisplayValue(data.getGodParentNames());
		
	}

	@Override
	public ArrayList<RciaPanelItem> getUpdates() {
		ArrayList<RciaPanelItem> itemList = new ArrayList<RciaPanelItem>();
		for(RciaPanelItem item: this.itemArrayList)
		{
			RciaPanelItem panelItem = (RciaPanelItem) item;
			if (panelItem.isSelected())
			{
				System.out.println("Value changed = " + panelItem.getNewValue() + " for " + transID);
			}
		}
		return itemList;
	}



}
