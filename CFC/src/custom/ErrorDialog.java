package custom;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class ErrorDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5638737953550232289L;

	public ErrorDialog() {
		getContentPane().setLayout(new BorderLayout());
		JLabel lblErrorOccured = new JLabel("Error Occured");
		getContentPane().add(lblErrorOccured, BorderLayout.CENTER);
	}
	
	public ErrorDialog(Exception ex) {
		getContentPane().setLayout(new BorderLayout());
		JLabel lblErrorOccured = new JLabel(ex.toString());
		getContentPane().add(lblErrorOccured, BorderLayout.CENTER);
	}



}
