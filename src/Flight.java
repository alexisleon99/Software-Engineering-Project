import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
	String flightNum;
	String originAirport;
	String destinationAriport;
	boolean isFull;
	double potentialValue;
	double actualValue;
	LocalDate departureDate;
	LocalTime departureTime;
	
	public String getFlightNum() {
		return flightNum;
	}

}
