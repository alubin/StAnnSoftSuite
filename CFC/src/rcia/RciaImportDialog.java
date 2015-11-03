package rcia;

import dialog.ImportDialog;

public class RciaImportDialog extends ImportDialog {

	private static final long serialVersionUID = 8355038020005999736L;
	final static String rciaTitle = "Select Rcia File to Import";

	public RciaImportDialog()
	{
		super(rciaTitle, new RciaActionListener());
	}

}
