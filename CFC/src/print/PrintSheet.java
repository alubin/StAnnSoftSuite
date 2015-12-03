package print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import database.DatabaseStore;
import database.DbConnectErrorDialog;
import database.DbWorker;

import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class PrintSheet extends JDialog {

private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	private  MainFrame mainGui;

	private DbWorker db;
	private Connection con;
	private JLabel lbl;

	public PrintSheet(final MainFrame mainGui) {
		setResizable(false);

		this.mainGui = mainGui;

		setAlwaysOnTop(true);

		setBounds(100, 100, 200, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		URL url = getClass().getResource("/images/loading_bar_small.gif");
		Icon img = new ImageIcon(url);
		lbl = new JLabel(img);
		lbl.setBounds(5, 51, 154, 17);
		lbl.setVisible(false);
		contentPane.add(lbl);
		
		JButton acceptButton = new JButton("Accept");
		acceptButton.setBounds(10, 23, 77, 23);
		
		acceptButton.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
						
						lbl.setVisible(true);
						contentPane.repaint();
						contentPane.revalidate();
						
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


						String OUT_PUT = "./sign_in_sheet.xlsx";

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
						    JOptionPane.showMessageDialog(mainGui, "<html>The sign-in sheet was successfully created</html>");

						    lbl.setVisible(false);
						    setVisible(false);
						    lbl.repaint();
						    
						    //Opens file after completed export
						    OpenFile(OUT_PUT);
					    } catch (JRException ex) {
					        ex.printStackTrace();
					        lbl.setVisible(false);
					        lbl.repaint();
					        JOptionPane.showMessageDialog(mainGui, "<html>The sign-in sheet could not be created due to an error:<br>" + ex + "</html>", "Error", JOptionPane.ERROR_MESSAGE);
					    }


					}
				});
				contentPane.setLayout(null);
				
				JLabel lblPrintSignSheet = new JLabel("Print Sign-In Sheet: ");
				lblPrintSignSheet.setBounds(33, 4, 131, 14);
				contentPane.add(lblPrintSignSheet);
				contentPane.add(acceptButton);
		
				JButton button = new JButton("Cancel");
				button.setBounds(97, 23, 87, 23);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
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