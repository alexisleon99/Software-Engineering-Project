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
	
	public Flight(String flightNum,String originAirport, String destinationAirport
			,int hour,int minute) {
		this.flightNum = flightNum;
		this.originAirport = originAirport;
		this.destinationAriport = destinationAirport;
		departureDate = LocalDate.now();
		departureTime = LocalTime.of(hour, minute);
	}
	
	public String getFlightNum() {
		return flightNum;
	}

}
