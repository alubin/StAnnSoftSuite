package custom;

/**
 * This class is to be used to relay the file path information from the convert button
 * press to the appropriate action listener.
 * @author andy.lubin
 *
 */
public abstract class Convert {

	//The file name of the Access or Excel file to be converted.
	private StringBuilder fileName = new StringBuilder();

	/**
	 * Sets the file name to be used to grab the file information.
	 * @param file
	 */
	public void setFilePath(StringBuilder file) {
		this.fileName = file;

	}

	/**
	 * Gets the file name
	 * @return
	 */
	public String getFilePath() {
		return fileName.toString();
	}

}
