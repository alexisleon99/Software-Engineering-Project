import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

class LoginTest {
	Person person = new Person("Ajay","patel", "123456789", 1000);
	
	@Test
	void testMain() throws IOException, ParseException {
		Login.main(null);
	}

}
