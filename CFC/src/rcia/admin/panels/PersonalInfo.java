package rcia.admin.panels;

import java.awt.Component;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.DatabaseStore;
import database.DbResult;
import database.DbWorker;
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
	private RciaPanelItem firstNameItem = new RciaPanelItem("First","First_Name");
	private RciaPanelItem lastNameItem = new RciaPanelItem("Last","Last_Name");
	private RciaPanelItem midNameItem = new RciaPanelItem("Middle","Middle_Name");
	private RciaPanelItem genderItem = new RciaPanelItem("Gender","Gender");
	private RciaPanelItem familiarNameItem = new RciaPanelItem("Familiar Name","Familiar_Name");
	private RciaPanelItem roleNameItem = new RciaPanelItem("Role","Roles");
	private RciaPanelItem birthNameItem = new RciaPanelItem("Birth Name","Birth_Name");
	private RciaPanelItem addressItem = new RciaPanelItem("Address","Address");
	private RciaPanelItem cityItem = new RciaPanelItem("City","City");
	private RciaPanelItem stateItem = new RciaPanelItem("State","State");
	private RciaPanelItem zipItem = new RciaPanelItem("Zip","Zip");
	private RciaPanelItem emailItem = new RciaPanelItem("Email","Email");
	private RciaPanelItem phoneItem = new RciaPanelItem("Phone","Phone");
	private RciaPanelItem dobItem = new RciaPanelItem("DOB","DOB");
	private RciaPanelItem ageItem = new RciaPanelItem("Age","Age");
	private RciaPanelItem occupationItem = new RciaPanelItem("Occupation","Occupation");
	private RciaPanelItem saintItem = new RciaPanelItem("Saint","Saint");
	private RciaPanelItem bpCityItem = new RciaPanelItem("Birth Place City","Birthplace_City");
	private RciaPanelItem bpStateItem = new RciaPanelItem("Birth Place State","Birthplace_State");
	private RciaPanelItem birthCertItem = new RciaPanelItem("Birth Certificate","Birth_Cert");
	private RciaPanelItem fatherItem = new RciaPanelItem("Father Full Name","Father_Full_Name");
	private RciaPanelItem motherItem = new RciaPanelItem("Mother Full Name","Mother_Full_Name");
	private ArrayList<RciaPanelItem> itemArrayList;
	private String transID;

	public PersonalInfo()
	{
		super(new GridLayout(1,1));
		JPanel personal = new JPanel(new GridLayout(23,1));
		JScrollPane scrollPanel = new JScrollPane(personal);
		itemArrayList =new ArrayList<RciaPanelItem>();

		itemArrayList.add(firstNameItem);
		itemArrayList.add(midNameItem);
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
		itemArrayList.add(fatherItem);
		itemArrayList.add(motherItem);

		personal.add(firstNameItem);
		personal.add(midNameItem);
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
		personal.add(fatherItem);
		personal.add(motherItem);

		add(scrollPanel);
	}

	public void setData(DbResult<RciaData> dbData)
	{
		RciaData data = dbData.getData();
		transID = dbData.getTransId();
		firstNameItem.setDisplayValue(data.getFirst());
		midNameItem.setDisplayValue(data.getMiddle());
		lastNameItem.setDisplayValue(data.getLast());
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
		fatherItem.setDisplayValue(data.getFatherFullName());
		motherItem.setDisplayValue(data.getMotherFullName());

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
