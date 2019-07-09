import static org.junit.jupiter.api.Assertions.*;

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

	
	//commited it out but just in case we need to implement it later 
	/*
	@Test
	void testMenu() {
		//fail("Not yet implemented");
	}
	*/
}
