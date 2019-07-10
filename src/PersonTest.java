import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class PersonTest {



	@Test
	void testMenu() throws IOException {
		int expectedResponse = 1;//create an expected putput
		Person e = new Person("Jose", "Delgado", "12",10000);//they created an object to test
		int actualPay = e.menu();//they call the method they are testing
		assertEquals(expectedResponse, actualPay);//compare 
	}

}
