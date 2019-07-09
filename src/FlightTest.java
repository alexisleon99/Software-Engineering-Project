import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlightTest {

	@Test
	void testFlight() {
		String Airline = "Delta";
		String fname = "Alexis";
		String ssn = "84812789";
		double budget = 10000;
		Flight test = new Flight(Airline,fname,ssn,budget);

		//flight test = new Flight();
	}

	@Test
	void testSearch() {
		fail("Not yet implemented");
	}

}
