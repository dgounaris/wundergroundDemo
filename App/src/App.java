import connection.ConnectionManager;
import utilities.HistoryMetricsHelper;

public class App {
	
	public static void main (String[] args) {
		HistoryMetricsHelper myMetrics = new HistoryMetricsHelper(
				ConnectionManager.getDateHistory(30, 10, 2017));
	}
	
}
