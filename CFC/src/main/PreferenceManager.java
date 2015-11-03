package main;

import java.util.prefs.Preferences;

public class PreferenceManager {

	private final Preferences prefs;
	final String databaseAddress = "databaseSetting";
	final String databasePort = " databasePort";

	public PreferenceManager()
	{
		prefs = Preferences.userRoot().node(this.getClass().getName());
	}

	public DatabaseStore getDatabaseSettings()
	{
		String databaseAddress = prefs.get(this.databaseAddress, "127.0.0.1");
		int databasePort = prefs.getInt(this.databasePort, 123);
		return new DatabaseStore(databaseAddress, databasePort);
	}

	public void setDatabaseSettings(String address, int port)
	{
		prefs.put(databaseAddress, address);
		prefs.putInt(databasePort, port);
	}

}
