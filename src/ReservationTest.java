import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReservationTest {

	@Test
	void testpurchase() throws IOException, ParseException {
		HashMap <String,Double> map = new HashMap();
		map.put("Austin", (double) 3500);
		String visit = "Austin";
		String ssn = "123456789";
		
		if(map.containsKey(visit)) {
			Double ecost =  (Double) map.get(visit);	
			Reservation actual = new Reservation("delta", null, ssn, 10000.0, map);
			double acost = actual.purchase("Austin",ssn);
			assertEquals(ecost,acost);
		}
	}
	
	@Test
	void testCashCheck() {
		double expected = 3000.0;

		Reservation r = new Reservation(null, null, null, 10000.0, null);
		
		double actual = r.CashCheck(7000.0,10000.0);

		assertEquals(expected,actual);
	}
	
	@Test
	void testFinalizePurchase() throws IOException, ParseException {
		testCashCheck();
		double budget = 10000.0;
		String ssn = "123456789";
		String expected= "reservations" + "123456789" + ".txt";
		
		Reservation fp = new Reservation(" ", " ", ssn, budget, null);
		String actual = fp.FinalizePurchase(0.0, 'a', 2, "Austin", "yes", ssn);
		
		assertEquals(expected,actual);
				
		
		
	}


}
