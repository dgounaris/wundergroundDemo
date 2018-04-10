package utilities;

import org.json.JSONObject;

public class HistoryMetricsHelper {

	private int maxHumidity;
	private int maxTemp;
	private int minTemp;
	private double precipitation; 
	
	public HistoryMetricsHelper(JSONObject object) {
		//we only fetch the relevant values from the data
		//if we need more values they can be easily added later
		this.maxHumidity = object.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("maxhumidity");
		this.maxTemp = object.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("maxtempm");
		this.minTemp = object.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getInt("mintempm");
		this.precipitation = object.getJSONObject("history").getJSONArray("dailysummary").getJSONObject(0).getDouble("precipm");
	}
	
	public int getMaxHumidity() { return maxHumidity; }
	public int getMaxTemp() { return maxTemp; }
	public int getMinTemp() { return minTemp; }
	public double getPrecipitation() { return precipitation; }
	
}
