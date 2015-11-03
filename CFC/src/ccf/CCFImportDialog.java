package ccf;

import dialog.ImportDialog;

public class CCFImportDialog extends ImportDialog {

	private static final long serialVersionUID = 2976549852767653724L;

	final static String ccfTitle = "Select CCF File to Import";
	public CCFImportDialog()
	{
		super(ccfTitle, new CCFActionListener());
	}

}
