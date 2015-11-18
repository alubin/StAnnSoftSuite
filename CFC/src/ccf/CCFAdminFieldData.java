package ccf;

import java.util.ArrayList;

public class CCFAdminFieldData {

	private final String selected;
	private final CCFData data;

	public CCFAdminFieldData(CCFData data)
	{
		selected = "";
		this.data = data;
	}

	public Object[] getObjArray()
	{
//		Object[] returnObj = new Object[data.getObjArray().length + 1];
		ArrayList<Object> returnObj= new ArrayList<Object>();
		returnObj.add(selected);
		for(int i = 0; i < data.getObjArray().length; i++ )
		{
//			returnObj[i] = data.getObjArray()[i];
//			System.out.println(returnObj[i]);
			returnObj.add(data.getObjArray()[i]);
		}
		return returnObj.toArray();
	}

}
