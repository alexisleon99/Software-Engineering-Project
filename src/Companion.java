import java.util.*;
public class Companion {
	Person p;
	String fName,lName;
	Flight flight;
	
	public Companion(String fName, String lName,Person p) {
		this.p = p;
		this.fName = fName;
		this.lName = lName;
	}
	
	public String whoIsMyPerson() {
		return p.getName();
	}
}
