package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
			e.printStackTrace();

		}
		new MainFrame();

	}

}
