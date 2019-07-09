import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class ReservationTest {
	HashMap map = new HashMap();
	
	Reservation expected = new Reservation("Delta","Ajay","123456789",1000.00,map);
	
	@Test
	void testReservation() {
		String airline = "Delta";
		String fname = "Ajay";
		String ssn = "123456789";
		double budget  = 1000.00;
		HashMap  map2 = new HashMap();
		
		Reservation actual = new Reservation(airline,fname,ssn,budget,map2);
		System.out.println(expected.equals(expected));
		assertTrue(expected.equals(actual));
		
	}

	/*@Test
	void testPurchase() {
		fail("Not yet implemented");
	}

	@Test
	void testDirectp() {
		fail("Not yet implemented");
	}
*/
}
