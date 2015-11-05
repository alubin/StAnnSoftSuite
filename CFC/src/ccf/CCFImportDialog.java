package ccf;

import main.MainFrame;
import dialog.ImportDialog;

public class CCFImportDialog extends ImportDialog {

	private static final long serialVersionUID = 2976549852767653724L;

	private final static String ccfTitle = "Select CCF File to Import";
	
	public CCFImportDialog(MainFrame instance) {
		super(ccfTitle, new CCFActionListener(instance));
	}

}
