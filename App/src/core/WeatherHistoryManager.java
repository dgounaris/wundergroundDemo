package core;

import org.json.JSONObject;

import connection.ConnectionManager;

public class WeatherHistoryManager {

	private JSONObject response;
	private int maxHumidity;
	private int maxTemp;
	private int minTemp;
	private double precipitation;
	private String day;
	
	public WeatherHistoryManager(int day, int month, int year) {
		//we only fetch the relevant values from the data
		//if we need more values they can be easily added later
		this.day = Integer.toString(day) + Integer.toString(month) + Integer.toString(year);
		response = ConnectionManager.getDateHistory(day, month, year);
		this.maxHumidity = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("maxhumidity");
		this.maxTemp = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("maxtempm");
		this.minTemp = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("mintempm");
		this.precipitation = response.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getDouble("precipm");
	}
	
	public String getDay() { return day; }
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
