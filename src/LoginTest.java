import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

class LoginTest {
	Person person = new Person("Ajay","patel", "123456789", 1000);
	
	@Test
<<<<<<< HEAD
	void testMain() throws IOException, ParseException {
		Login.main(null);
=======
	void testMain() {
		String expected = "Ajay patel";
		String actual = person.getName();
		assertEquals(expected,actual);
	
>>>>>>> ee249392864489a4c70bdff60715d3af9c57701d
	}

}
