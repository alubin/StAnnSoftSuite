package ccf.export;

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

public class CCFAccessExport {
	
	MainFrame mainGui;

	public CCFAccessExport(MainFrame instance)
	{		
		mainGui = instance;
		try {
			JPanel myPanel = new JPanel();
			DbWorker dbWorker = new DbWorker();
			Database db;

			db =DatabaseBuilder.create(Database.FileFormat.V2007, new File("CCFData.accdb"));
			new ImportUtil.Builder(db, "Updated CCF").importResultSet(dbWorker.retrieveCCFDataSet(QueryType.all, ""));
			db.close();
			dbWorker.dbClose();
			myPanel.add(new JLabel("File Exported"));
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
