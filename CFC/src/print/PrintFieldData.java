package print;

import java.util.ArrayList;

public class PrintFieldData {
	private final String selected;
	private final PrintData data;
	
	public PrintFieldData(PrintData printData)
	{
		selected = "";
		data = printData;
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
