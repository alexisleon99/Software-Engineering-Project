import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class SeatTest {

	@Test
	void testSeat() {
		fail("Not yet implemented");
	}

	@Test
	void testSeatClass() throws FileNotFoundException {
		String expectedResponse = "First";//create an expected putput
		Seat chair = new Seat(3500,"Austin" );
		String actualResponse = chair.SeatClass((double) 7000,"First");//they call the method they are testing
		assertSame(expectedResponse, actualResponse);//compare 
	}

	@Test
	void testSeatChart() {
		fail("Not yet implemented");
	}

}
