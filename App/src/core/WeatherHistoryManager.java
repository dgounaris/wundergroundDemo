package core;

import org.json.JSONObject;

import connection.ConnectionManager;
import utilities.Date;
import utilities.Location;

public class WeatherHistoryManager {

	private JSONObject response;
	private int maxHumidity;
	private int maxTemp;
	private int minTemp;
	private double precipitation;
	private Date date;
	private Location location;
	
	public WeatherHistoryManager(int day, int month, int year, Location location) {
		//we only fetch the relevant values from the data
		//if we need more values they can be easily added later
		this.date = new Date(day, month, year);
		this.location = location;
		response = ConnectionManager.getDateHistory(date, location);
		this.maxHumidity = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("maxhumidity");
		this.maxTemp = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("maxtempm");
		this.minTemp = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("mintempm");
		this.precipitation = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getDouble("precipm");
	}
	
	public void reload() {
		response = ConnectionManager.getDateHistory(date, location);
		this.maxHumidity = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("maxhumidity");
		this.maxTemp = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("maxtempm");
		this.minTemp = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("mintempm");
		this.precipitation = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getDouble("precipm");
	}
	
	public String getDate() { return date.toString(); }
	public int getMaxHumidity() { return maxHumidity; }
	public int getMaxTemp() { return maxTemp; }
	public int getMinTemp() { return minTemp; }
	public double getPrecipitation() { return precipitation; }
	
	public String getMetricsInfo() {
		return "Max humidity: " + this.maxHumidity + 
				"\nMax temperature: " + this.maxTemp + 
				"\nMin temperature: " + this.minTemp +
				"\nPrecipitation: " + this.precipitation;
	}
	
}
