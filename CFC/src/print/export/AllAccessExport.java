package print.export;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rcia.export.RciaAccessExport;
import main.MainFrame;
import ccf.export.CCFAccessExport;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.util.ImportUtil;

import custom.ErrorDialog;
import database.DbWorker;
import database.QueryType;

public class AllAccessExport {
	
	MainFrame mainGui;

	public AllAccessExport(MainFrame instance)
	{		
		mainGui = instance;
		JPanel myPanel = new JPanel();
		new CCFAccessExport(instance);
		new RciaAccessExport(instance);
		myPanel.add(new JLabel("RCIA and CCF Access File Exported"));
		mainGui.setPanel(myPanel);
		
	}


}
