package ccf;

import java.util.ArrayList;

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
