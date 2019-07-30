import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
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
<<<<<<< HEAD
		HashMap actual = Flight.lists("delta");
		
		assertEquals(expected,actual);
	}
	
	void testSearch() {
		
	}
}

=======
		HashMap actual = flight.search("delta");
		
		ReservationTest rt = new ReservationTest();
		rt.testpurchase();
		
		assertEquals(expected,actual);
	}
}
>>>>>>> ee249392864489a4c70bdff60715d3af9c57701d
