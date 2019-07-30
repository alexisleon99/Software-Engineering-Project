import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

class PersonTest {
	Person person = new Person("Ajay","patel", "123456789", 1000);
	
	@Test
	void testPerson() {	
		String expected = "Ajay patel";
		String actual = person.getName();
		assertEquals(expected,actual);
	}

	@Test
	void testGetName() {
		String expected = "Ajay patel";
		String actual = person.getName();
		assertEquals(expected,actual);
	}

	@Test
	void testGetSsn() {
		String expected = "123456789";
		String actual1 = person.getSsn();
		assertEquals(expected,actual1);	
	}

	//Simulates the program running 
	@Test
	void testMenu() throws IOException, ParseException {
		String expectedResponse = "1";//create an expected putput
		Person e = new Person("Jose", "Delgado", "123456789",10000.0);//they created an object to test
		String actualResponse = e.menu();//they call the method they are testing
		assertEquals(expectedResponse, actualResponse);//compare 
	}
	
	@Test
	void testCancelMenu() throws IOException, ParseException {
		String ssn = "123456789";
		String expect = "cancel";
		Person e = new Person("Jose", "Delgado", ssn,10000.0);//they created an object to test
		String actual = e.cancelMenu(ssn);
		assertEquals(expect, actual);//compare 
	}
}
