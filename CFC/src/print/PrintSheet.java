package print;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import database.DatabaseStore;
import database.DbConnectErrorDialog;
import database.DbWorker;


import java.awt.Desktop;

import com.toedter.calendar.JDateChooser;



public class PrintSheet extends JDialog {

private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	private  MainFrame mainGui;
//	private PrintDisplayPanel printDisplayPanel;

	private DbWorker db;
	private Connection con;

	public PrintSheet(final MainFrame mainGui) {
		setResizable(false);

		this.mainGui = mainGui;

		setAlwaysOnTop(true);

		setBounds(100, 100, 220, 115);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrintSignSheet = new JLabel("Print Sign-In Sheet: ");
		lblPrintSignSheet.setBounds(10, 11, 149, 24);
		contentPane.add(lblPrintSignSheet);

		JButton btnNewButton = new JButton("Accept");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					db = new DbWorker(DatabaseStore.getAddress(), DatabaseStore.getPort(),
							DatabaseStore.getUserName(), DatabaseStore.getPassword());
					con = db.getConnection();

				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					new DbConnectErrorDialog().setVisible(true);
				}


				String OUT_PUT = "C:/tmp/sign_in_sheet.xlsx";

				String REPORT = "/certificates/Signing_List.jrxml";

				HashMap<String, Object> map = new HashMap<>();
				//map.put("FirstName",firstName);

				try
				{
					JasperDesign jd  = JRXmlLoader.load(getClass().getResourceAsStream(REPORT));
			        JasperReport jr = JasperCompileManager.compileReport(jd);
			        JasperPrint jp = JasperFillManager.fillReport(jr, map, con);
			        JRXlsxExporter export = new JRXlsxExporter();
				    export.setExporterInput(new SimpleExporterInput(jp));
				    export.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(OUT_PUT)));
				    SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
				    export.setConfiguration(config);
				    export.exportReport();
				    JOptionPane.showMessageDialog(mainGui, "<html>The sign-in sheet was successfully created");

				    setVisible(false);

				    //Opens file after completed export
				    OpenFile(OUT_PUT);
			    } catch (JRException ex) {
			        ex.printStackTrace();
			        JOptionPane.showMessageDialog(mainGui, "<html>The sign-in sheet could not be created due to an error:<br>" + ex + "</html>", "Error", JOptionPane.ERROR_MESSAGE);
			    }


			}
		});
		btnNewButton.setBounds(10, 46, 89, 23);
		contentPane.add(btnNewButton);

		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setBounds(115, 46, 89, 23);
		contentPane.add(button);
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