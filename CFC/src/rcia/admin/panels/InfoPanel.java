package rcia.admin.panels;

import java.util.ArrayList;

import database.DbResult;
import rcia.RciaData;

interface InfoPanel {
	
	void setData(DbResult<RciaData> data);
	ArrayList<RciaPanelItem> getUpdates();

}
