package ccf;

import javax.swing.filechooser.FileNameExtensionFilter;

import main.MainFrame;
import dialog.ImportDialog;

public class CCFImportDialog extends ImportDialog {

	private static final long serialVersionUID = 2976549852767653724L;

	private final static String ccfTitle = "Select CCF File to Import";
	
	public CCFImportDialog(MainFrame instance) {
		super(ccfTitle, new CCFActionListener(instance));
	}
	
	@Override
	public FileNameExtensionFilter getFilter() {
		return new FileNameExtensionFilter("Access Files", "accdb", "mdb");
	}

}
