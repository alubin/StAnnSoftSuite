package database;

import java.util.prefs.Preferences;

public class DatabaseStore {

	private Preferences pref = Preferences.userRoot().node(this.getClass().getName());;	
	private String userPref = "user";
	private String passPref = "pass";
	private String portPref = "port";
	private String addressPref = "address";
	
	private String ipAddress =  pref.get(addressPref, "172.16.28.52"); ;
	private int dbPort = pref.getInt(portPref, 3306);;
	private String userName = pref.get(userPref, "ccf");
	private String password = pref.get(passPref, "block958@tuners");
	
	private static DatabaseStore sessionSettings = new DatabaseStore();
	

	
	public DatabaseStore()
	{
		
	}

	public DatabaseStore(String address, int port, String userName, String password)
	{
		this.ipAddress = address;
		this.dbPort = port;
		this.userName = userName;
		this.password = password;
	}

	public String getAddress()
	{
		return ipAddress;
	}

	public int getPort()
	{
		return dbPort;
	}

	public void setAddress(String address) {
		ipAddress = address;

	}

	public void setPort(int port) {
		dbPort = port;

	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(String user) {
		userName = user;

	}

	public void setPass(String pass) {
		password = pass;

	}
	
	public static void setSession(DatabaseStore data)
	{
		sessionSettings = data;
	}
	

	public static DatabaseStore getSession()
	{
		return sessionSettings;
	}

	public void setDefault(DatabaseStore data)
	{
		pref.put(userPref, data.getUserName());
		pref.put(passPref, data.getPassword());
		pref.put(addressPref, data.getAddress());
		pref.putInt(portPref, data.getPort());

	}
	
	public void useDefault()
	{
		String user = pref.get(userPref, getUserName());
		String pass = pref.get(passPref, getPassword());
		String address = pref.get(addressPref, getAddress());
		int port = pref.getInt(portPref, getPort());
		
		sessionSettings = new DatabaseStore(address,port,user,pass);
	}

	@Override
	public String toString() {
		return "DatabaseStore [ipAddress=" + ipAddress + ", dbPort=" + dbPort
				+ ", userName=" + userName + ", password=" + password + "]";
	}


}
