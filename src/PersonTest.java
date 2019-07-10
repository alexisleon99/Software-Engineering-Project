import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

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

	@Test
	void testMenu() throws IOException {
		int expectedResponse = 1;//create an expected putput
		Person e = new Person("Jose", "Delgado", "12",10000);//they created an object to test
		int actualPay = e.menu();//they call the method they are testing
		assertEquals(expectedResponse, actualPay);//compare 
	}
}
