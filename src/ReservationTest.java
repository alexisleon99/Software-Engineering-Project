import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReservationTest {

	@Test
	void testpurchase() throws IOException {
		HashMap <String,Double> map = new HashMap();
		map.put("Austin", (double) 3500);
		String visit = "Austin";
		
		if(map.containsKey(visit)) {
			Double ecost =  (Double) map.get(visit);	
			Reservation actual = new Reservation("delta", null, null, 10000.0, map);
			double acost = actual.purchase("Austin");
			assertEquals(ecost,acost);
		}
	}
	
	@Test
	void testCashCheck() {
		double expected = 3000;
		Reservation r = new Reservation(null, null, null, 10000.0, null);
		double actual = Reservation.CashCheck(7000.0,10000.0);
		assertEquals(expected,actual);
	}
	
	@Test
	void testFinalizePurchase() {
		
	}


}
