import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

class CancelationTest {

	@Test
	void testcancel() throws IOException {
		String ssn = "123456789";
		String expectedFile = "reservations"+ssn+".txt";
		Cancelation actualFile = new Cancelation(ssn);
		
		String actual = actualFile.cancel(ssn);
		assertEquals(expectedFile,actual);
		

	}
	
	@Test
	void testReschedule() throws IOException, ParseException {
		String ssn = "123456789";
		String expectedFile = "reservations"+ssn+".txt";
		Cancelation actualFile = new Cancelation(ssn);
		
		String actual = actualFile.reschedule(ssn);
		assertEquals(expectedFile,actual);
		
	}
	
	@Test
	void testRefund() throws IOException {
		String ssn = "123456789";
		String expectedFile = "Refund"+ssn+".txt";
		Cancelation actualFile = new Cancelation(ssn);
		
		String actual = actualFile.refund(ssn);
		assertEquals(expectedFile,actual);
	}

}
