package rcia.admin.panels;

import java.sql.SQLException;
import java.util.ArrayList;

import database.DbResult;
import rcia.RciaData;

interface InfoPanel {

	void setData(DbResult<RciaData> data);
	ArrayList<RciaPanelItem> storeUpdates() throws SQLException;

}
