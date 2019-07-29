import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class FlightTest {

	@Test
	void testlists() throws IOException, ParseException {
		Flight p1 = new Flight("delta", "alex","123456789",10000);
		String airline = "delta", answer = "yes";
		double budget = 10000,cost =7000; 
		HashMap locations = new HashMap();
		p1.addCompanion(airline,budget,locations,answer,cost);
		//lists("delta");
		
	}

}
