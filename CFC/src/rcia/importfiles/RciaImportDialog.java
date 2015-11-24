package rcia.importfiles;

import javax.swing.filechooser.FileNameExtensionFilter;

import rcia.admin.RciaActionListener;
import main.MainFrame;
import dialog.ImportDialog;

public class RciaImportDialog extends ImportDialog {

	private static final long serialVersionUID = 8355038020005999736L;
	final static String rciaTitle = "Select Rcia File to Import";

	public RciaImportDialog(MainFrame instance)
	{
		super(rciaTitle, new RciaActionListener(instance));
	}

	@Override
	public FileNameExtensionFilter getFilter() {
		return new FileNameExtensionFilter("Excel Files", "xls","xlsx");
	}
}
