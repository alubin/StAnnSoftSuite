package print;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.*;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import database.DatabaseStore;
import database.DbConnectErrorDialog;
import database.DbWorker;

import java.sql.Connection;


public class PrintCertificate  
{	
	private static Connection con = null;
	DbWorker db = null;
	private static boolean exists;
	
	public PrintCertificate( String certType, String firstName, String lastName, Date baptismDate, Date confirmDate, String pastorName)
	{
		//Need to swtich from hard coded Connection to db.getConnection();
		//DbWorker db = new DbWorker();
		//con = db.getConnection();
		
		try
		{
			db = new DbWorker();
			con = db.getConnection();
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rcia", "root", "Sunshine222");
			
			exists = db.retrieveRciaData(firstName, lastName).size() > 0 ? true : false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			new DbConnectErrorDialog().setVisible(true);
		}
		
		if(exists)
		{
			
			URL url = PrintCertificate.class.getResource("/images/cert_logo.png");
			
			String OUT_PUT = "./certificate.docx";
			//String OUT_PUT = "./GeneratedCertificates/" + firstName.toLowerCase() + "_" + lastName.toLowerCase() + "_" + certType + ".docx";
			
			String REPORT = "";
			
			if(certType.equals("rite_of_christian_initiation_eng"))
			{
				REPORT = "/certificates/RCI_Eng.jrxml";
			}
			else if(certType.equals("rite_of_christian_initiation_span"))
			{
				REPORT = "/certificates/RCIA_Span.jrxml";
			}
			else if(certType.equals("confirmation_eng"))
			{
				REPORT = "/certificates/Confirm_Eng.jrxml";
			}
			else if(certType.equals("confirmation_span"))
			{
				REPORT = "/certificates/Confirm_Span.jrxml";
			}
			else if(certType.equals("first_communion_eng"))
			{
				REPORT = "/certificates/Communion_Eng.jrxml";
			}
			else if(certType.equals("first_communion_span"))
			{
				REPORT = "/certificates/Communion_Span.jrxml";
			}
				
				HashMap<String, Object> map = new HashMap<>();
				map.put("FirstName",firstName);
				map.put("LastName",lastName);
				map.put("PastorName", pastorName);
				map.put("DateOfBaptism", baptismDate);
				map.put("DateOfConfirmation", confirmDate);
				map.put("ImgUrl", url);
			
				try 
				{
					JasperDesign jd  = JRXmlLoader.load(getClass().getResourceAsStream(REPORT));
			        JasperReport jr = JasperCompileManager.compileReport(jd);
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
			        return;
			    }
		}
	}
	
	public boolean getExists()
	{
		return exists;
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
