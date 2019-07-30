/**
 * This class allows the airlines to list their flights as well as the capacity of those flights.
 * @author Jose Delgado
 * @author Alexis Leon
 * @author Ajay Patel
 */
import java.util.HashMap;
public class Airlines extends Login{
	
	/**
	 * This method for the airlines class simply shows a list of flight destinations along with their capacity.
	 * @param flights This is the different flights that the airline has.
	 * @param capacity This is how much room is in that flight.
	 * @return returns a hashMap for testing purposes
	 */
	
	public static HashMap list(HashMap<String, Double> flights, int[] capacity) {
		int counter = 0;
		for (String key : flights.keySet()) { 
			counter++;
		    System.out.println("Location is " + key + " it costs $" + flights.get(key) + " per ticket and has a capacity of " + capacity[counter-1]);
		}
		return flights;
	}
}
