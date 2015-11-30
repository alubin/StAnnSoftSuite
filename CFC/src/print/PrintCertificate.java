package print;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.export.ooxml.*;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.*;

import database.DatabaseStore;
import database.DbConnectErrorDialog;
import database.DbWorker;

import java.sql.Connection;
import java.sql.SQLException;



public class PrintCertificate
{
	private static Connection con = null;

	public PrintCertificate( String certType, String firstName, String lastName, Date confirmDate, String pastorName)
	{
		try
		{
			con = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
					DatabaseStore.getUserName(), DatabaseStore.getPassword()).getConnection();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			new DbConnectErrorDialog().setVisible(true);
		}
		String OUT_PUT = "./GeneratedCertificates/" + firstName.toLowerCase() + "_" + lastName.toLowerCase() + "_" + certType + ".docx";
		String REPORT = "";

		if(certType.equals("rite_of_christian_initiation_eng"))
		{
			REPORT = "./certificates/RCI_Eng.jrxml";
		}
		else if(certType.equals("rite_of_christian_initiation_span"))
		{
			REPORT = "./certificates/RCIA_Span.jrxml";
		}
		else if(certType.equals("confirmation_eng"))
		{
			REPORT = "./certificates/Confirm_Eng.jrxml";
		}
		else if(certType.equals("confirmation_span"))
		{
			REPORT = "./certificates/Confirm_Span.jrxml";
		}
		else if(certType.equals("first_communion_eng"))
		{
			REPORT = "./certificates/Communion_Eng.jrxml";
		}
		else if(certType.equals("first_communion_span"))
		{
			REPORT = "./certificates/Communion_Span.jrxml";
		}

			HashMap<String, Object> map = new HashMap<>();
			map.put("FirstName",firstName);
			map.put("LastName",lastName);
			map.put("PastorName", pastorName);
			map.put("DateOfConfirmation", confirmDate);

			try
			{
		        JasperReport jr = JasperCompileManager.compileReport(ClassLoader.getSystemResourceAsStream(REPORT));
		        JasperPrint jp = JasperFillManager.fillReport(jr, map, con);
		        JRDocxExporter export = new JRDocxExporter();
			    export.setExporterInput(new SimpleExporterInput(jp));
			    export.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(OUT_PUT)));
			    SimpleDocxReportConfiguration config = new SimpleDocxReportConfiguration();
			    export.setConfiguration(config);
			    export.exportReport();

			    //Opens file after completed export
			    OpenFile(OUT_PUT);
		    } catch (JRException ex) {
		        ex.printStackTrace();
		    }

	}

	public void OpenFile(String path)
	{
		if (Desktop.isDesktopSupported()) {
		    try {
		        File myFile = new File(path);
		        Desktop.getDesktop().open(myFile);
		    } catch (IOException ex) {
		        // no application registered for PDFs
		    }
		}
	}
}
