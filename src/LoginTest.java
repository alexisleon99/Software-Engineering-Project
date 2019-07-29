import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginTest {
	Person person = new Person("Ajay","patel", "123456789", 1000);
	
	@Test
	void testMain() {
		String expected = "Ajay patel";
		String actual = person.getName();
		assertEquals(expected,actual);
	
	}

}
