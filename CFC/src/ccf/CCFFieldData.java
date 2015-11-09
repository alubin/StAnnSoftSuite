package ccf;

public class CCFFieldData {

	private final boolean selected;
	private final CCFData data;

	public CCFFieldData(CCFData data)
	{
		selected = false;
		this.data = data;
	}

	public Object[] getObjArray()
	{
		Object[] returnObj = new Object[data.getObjArray().length + 1];
		returnObj[0] = selected;
		for(int i = 1; i < data.getObjArray().length; i++ )
		{
			returnObj[i] = data.getObjArray()[i];
		}
		return returnObj;
	}

}
