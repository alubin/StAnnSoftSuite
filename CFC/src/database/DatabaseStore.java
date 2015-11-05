package database;

public class DatabaseStore {

	private static String ipAddress = "127.0.0.1";
	private static int dbPort = 3306;

	public DatabaseStore(String address, int port)
	{
		ipAddress = address;
		dbPort = port;
	}

	public static String getAddress()
	{
		return ipAddress;
	}

	public static int getPort()
	{
		return dbPort;
	}

	public static void setAddress(String address) {
		ipAddress = address;

	}

	public static void setPort(int port) {
		dbPort = port;

	}


}
