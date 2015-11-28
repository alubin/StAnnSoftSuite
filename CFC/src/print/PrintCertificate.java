package print;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.export.ooxml.*;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.File;
import java.sql.DriverManager;
import java.util.*;

import database.DbConnectErrorDialog;
import database.DbWorker;

import java.sql.Connection;
import java.sql.SQLException;



public class PrintCertificate  
{	
	private static Connection con = null;
	
	public PrintCertificate( String certType, String firstName, String lastName, String confirmDate, String pastorName)
	{
		DbWorker db = new DbWorker();
		//con = db.getConnection();
		
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rcia", "root", "Sunshine222");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			new DbConnectErrorDialog().setVisible(true);
		}
		String OUT_PUT = "C:/tmp/" + firstName.toLowerCase() + "_" + lastName.toLowerCase() + "_" + certType + ".docx";
		String REPORT = "";
		
		if(certType.equals("rite_of_christian_initiation_eng"))
		{
			REPORT = "certificates/RCI_Eng.jrxml";
		}
		else if(certType.equals("rite_of_christian_initiation_span"))
		{
			REPORT = "certificates/RCIA_Span.jrxml";
		}
		else if(certType.equals("confirmation_eng"))
		{
			REPORT = "certificates/Confirm_Eng.jrxml";
		}
		else if(certType.equals("confirmation_span"))
		{
			REPORT = "certificates/Confirm_Span.jrxml";
		}
		else if(certType.equals("first_communion_eng"))
		{
			REPORT = "certificates/Communion_Eng.jrxml";
		}
		else if(certType.equals("first_communion_span"))
		{
			REPORT = "certificates/Communion_Span.jrxml";
		}
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("FirstName",firstName);
			map.put("LastName",lastName);
			map.put("PastorName", pastorName);
			map.put("DateOfConfirmation", confirmDate);
			
			try {

		        JasperReport jr = JasperCompileManager.compileReport(
		                ClassLoader.getSystemResourceAsStream(REPORT));
		        JasperPrint jp = JasperFillManager.fillReport(jr, map, con);
		        JRDocxExporter export = new JRDocxExporter();
			    export.setExporterInput(new SimpleExporterInput(jp));
			    export.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(OUT_PUT)));
			    SimpleDocxReportConfiguration config = new SimpleDocxReportConfiguration();
			    export.setConfiguration(config);
			    export.exportReport();
		    } catch (JRException ex) {
		        ex.printStackTrace();   
		    }
			
		
	}
}
