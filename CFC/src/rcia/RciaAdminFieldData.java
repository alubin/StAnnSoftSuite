package rcia;

import java.util.ArrayList;

public class RciaAdminFieldData {
	private final String selected;
	private final RciaData data;
	
	public RciaAdminFieldData(RciaData rciaData)
	{
		selected = "";
		data = rciaData;
	}
	
	public Object[] getObjArray()
	{
		ArrayList<Object> rtnArray = new ArrayList<Object>();
		rtnArray.add(selected);
		for(int i = 0; i < data.getArray().length; i++)
		{
			rtnArray.add(data.getArray()[i]);
		}
		
		return rtnArray.toArray();
		
	}
	
	public String[] getStringArray()
	{
		ArrayList<Object> rtnArray = new ArrayList<Object>();
		rtnArray.add(selected);
		for(int i = 0; i < data.getArray().length; i++)
		{
			rtnArray.add(data.getArray()[i]);
		}
		
		return rtnArray.toArray(new String[rtnArray.size()]);
		
	}

}
