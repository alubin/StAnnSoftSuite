package ccf;

import javax.swing.filechooser.FileNameExtensionFilter;

import main.MainFrame;
import dialog.ImportDialog;

/**
 * This class inherits from the generic Import dialog and customizes it for the CCF Functionality.
 * @author AL
 *
 */
public class CCFImportDialog extends ImportDialog {

	private static final long serialVersionUID = 2976549852767653724L;

	private final static String ccfTitle = "Select CCF File to Import";
	
	public CCFImportDialog(MainFrame instance) {
		super(ccfTitle, new CCFImportActionListener(instance));
	}
	
	@Override
	public FileNameExtensionFilter getFilter() {
		return new FileNameExtensionFilter("Access Files", "accdb", "mdb");
	}

}
