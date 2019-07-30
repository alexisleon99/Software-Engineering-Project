import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class FlightTest {
	@Test
	void testLists() throws IOException {
		HashMap <String,Double> expected = new HashMap();
		expected.put("Austin", (double) 3500);
		expected.put("Portland", (double) 4500);
		expected.put("Chicago", (double) 3800);
		expected.put("Miami", (double) 3200);
		expected.put("New York", (double) 3000);
		expected.put("Arizona", (double) 5000);			
		HashMap actual = Flight.lists("delta");
		
		assertEquals(expected,actual);
	}
	@Test
	void testAddCompanion() throws IOException, ParseException {
		String flight = "delta",name = "alex",ssn = "1234", location = "Austin";
		double budget = 10000;
		Flight test = new Flight(flight, name, ssn, budget);
		HashMap loc = new HashMap();
		loc = test.lists(flight);
		Reservation trex = new Reservation(flight,name,ssn,budget,loc);
		
		test.addCompanion(flight, budget, loc, "yes", 7000);
		String expected = "reservations12341.txt";
		//String actual = searchFiles(ssn);
		String actual = searchFiles("reservations" + (ssn + "1") + ".txt");
		assertEquals(expected,actual);
		
	}
	public static String searchFiles(String name) throws IOException {
		String path = new File(".").getCanonicalPath();
		 File dir = new File(path);
	      String[] children = dir.list();
	      String s = null;
	      if (children == null) {
	         System.out.println("doesn't exist or is not a directory");
	      } else {
	         for (int i = 0; i < children.length; i++) {
	            s = children[i];
	            if(s.equals(name)) {
	            	return s;
	            }
	         }
	      }
	 

		return s;
	}
}