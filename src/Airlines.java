import java.util.HashMap;

public class Airlines extends Login{
	
	public static void list(HashMap<String, Double> map, int[] capacity) {
		int counter = 0;
		for (String key : map.keySet()) { 
			counter++;
		    System.out.println("Location is " + key + " it costs $" + map.get(key) + " per ticket and has a capacity of " + capacity[counter-1]);
		}
	}

}
