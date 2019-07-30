import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

class SeatTest {


	@Test
	void testSeatClass() throws IOException, ParseException {
		Double expectedResponse = 0.0;//create an expected output
		Seat chair = new Seat(0,"Austin" );
		
		double actual = Seat.SeatClass("Austin", "Austin","123456789");
		testSeatChart();
		assertEquals(expectedResponse, actual);//compare 
		
	}

	//Don't know how to test this accurately as it generates random numbers and characters
	@Test
	void testSeatChart() {
		
		
	}

}
