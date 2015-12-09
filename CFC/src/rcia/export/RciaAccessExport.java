package rcia.export;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainFrame;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.util.ImportUtil;

import custom.ErrorDialog;
import database.DbWorker;
import database.QueryType;

public class RciaAccessExport {
	
	MainFrame mainGui;

	public RciaAccessExport(MainFrame instance)
	{		
		mainGui = instance;
		try {
			JPanel myPanel = new JPanel();
			DbWorker dbWorker = new DbWorker();
			Database db;

			db =DatabaseBuilder.create(Database.FileFormat.V2007, new File("RciaData.accdb"));
			new ImportUtil.Builder(db, "Updated Rcia").importResultSet(dbWorker.retrieveRciaDataSet("",""));
			db.close();
			dbWorker.dbClose();
			myPanel.add(new JLabel("RCIA Access File Exported"));
			mainGui.setPanel(myPanel);
		} catch (IOException e) {
			new ErrorDialog(e);
			e.printStackTrace();
		} catch (SQLException e) {
			new ErrorDialog(e);
			e.printStackTrace();
		}
		
	}


}
