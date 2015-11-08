package database;

public class DatabaseStore {

	private static String ipAddress = "127.0.0.1";
	private static int dbPort = 3306;
	private static String userName;
	private static String password;

	public DatabaseStore(String address, int port)
	{
		ipAddress = address;
		dbPort = port;
	}
	
	public DatabaseStore(String address, int port, String userName, String password)
	{
		this.ipAddress = address;
		this.dbPort = port;
		this.userName = userName;
		this.password = password;
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

	public static String getUserName() {
		return userName == null ? "root" : userName;
	}

	public static String getPassword() {
		return password == null ? "Sunshine222" : password;
	}

	public static void setUser(String user) {
		userName = user;
		
	}

	public static void setPass(String pass) {
		password = pass;
		
	}


}
