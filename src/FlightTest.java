import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class FlightTest {
	Flight expectedTest = new Flight("Delta","Alexis","84812789",10000.00);
	@Test
	void testFlight() {
		
		String Airline = "Delta";
		String fname = "Alexis";
		String ssn = "84812789";
		double budget = 10000.00;
		Flight test = new Flight(Airline,fname,ssn,budget);
		System.out.println(test.equals(expectedTest));
		assertTrue(test.equals(test));
	}
	@Test
	void testSearch() {
		try {
			HashMap <String,Double> map2 = new HashMap();
			map2.put("Austin", (double) 3500);
			System.out.println("please enter Austin for the location");
			System.out.println(map2.entrySet());
			expectedTest.search();
			//System.out.println(map.entrySet());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




}
