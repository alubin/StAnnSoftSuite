package main;

public class DatabaseStore {

	private final String ipAddress;
	private final int port;

	public DatabaseStore(String address, int port)
	{
		ipAddress = address;
		this.port = port;
	}

	public String getAddress()
	{
		return ipAddress;
	}

	public int getPort()
	{
		return port;
	}


}
