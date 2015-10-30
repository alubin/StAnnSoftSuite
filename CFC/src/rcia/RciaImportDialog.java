package rcia;

import dialog.ImportDialog;

public class RciaImportDialog extends ImportDialog {
	
	private static final long serialVersionUID = 8355038020005999736L;

	public RciaImportDialog()
	{
		super("Select Rcia File to Import", new RciaActionListener());
	}
	
}
