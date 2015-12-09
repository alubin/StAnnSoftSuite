package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.log4j.BasicConfigurator;

import custom.ErrorDialog;

/**
 * This is the main class of the program.
 * @author AL
 *
 */
public class SoftwareSuite {

	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		        else
		        {
		        	UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
			new ErrorDialog(e);
			e.printStackTrace();

		}
		//DO NOT DELETE: Required in Main Method for JasperReports to configure internal settings. 
		BasicConfigurator.configure();
		new MainFrame();

	}

}
