package database;

public class DbResult<T> {
	T data;
	String transID;
	
	public DbResult(T data, String id)
	{
		this.data = data;
		this.transID = id;
	}
	
	public T getData()
	{
		return data;
	}
	
	public String getTransId()
	{
		return transID;
	}
	
	@Override
	public String toString()
	{
		return data.toString();
	}

}
