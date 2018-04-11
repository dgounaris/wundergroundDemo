import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import core.WeatherHistoryManager;
import utilities.IOHelper;
import utilities.Location;

public class App {
	
	private static final Logger logger = Logger.getLogger(App.class.getName());
	
	public static void main (String[] args) {
		Location newYork = new Location("New York", "NY");
		WeatherHistoryManager myMetrics = new WeatherHistoryManager(30,10,2017,newYork);
		try {
			IOHelper.WriteFile("metrics" + myMetrics.getDate(), myMetrics.getMetricsInfo());
		} catch (IOException e) {
			logger.log(Level.FINEST, "Could not save metrics file", e);
		}
	}
	
}
