import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ReservationTest {

	@Test
	void testReservation() {
		fail("Not yet implemented");
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
