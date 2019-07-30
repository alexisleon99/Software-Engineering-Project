import java.util.HashMap;

public class Airlines extends Login{
	
	public static HashMap list(HashMap<String, Double> flights, int[] capacity) {
		int counter = 0;
		for (String key : flights.keySet()) { 
			counter++;
		    System.out.println("Location is " + key + " it costs $" + flights.get(key) + " per ticket and has a capacity of " + capacity[counter-1]);
		}
		return flights;
	}
}
