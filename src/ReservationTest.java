import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
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

	@Test
	void testPurchase() {
	       Map<String, Double> map = new HashMap<>();
	        map.put("Austin", (double) 3500);
			System.out.println("Choose which location you will like to visit");
			String visit = "Austin";
			
			if(map.containsKey(visit)) {
				Double cost =  (Double) map.get(visit);
				Seat type = new Seat(cost,visit);
				try {
					type.SeatClass(cost,visit);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
	}

	@Test
	void testCashCheck() {
		double balance = 3000;
		Reservation r = new Reservation(null, null, null, 10000, null);
		double actual = Reservation.CashCheck(7000.0,10000.0);
		assertEquals(balance,actual);
	}
	
	@Test
	void testFinalizePurchase() {
		fail("Not yet implemented");
	}

}
