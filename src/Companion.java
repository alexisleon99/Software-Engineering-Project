/**
 * This class implements a simple object of Companion.
 * <p>
 * It essentially creates the companions for the user.
 * </P>
 * @author Jose Delgado
 * @author Alexis Leon
 * @author Ajay Patel
 */
import java.util.*;

public class Companion {
	Person p;
	String fName,lName;
	Flight flight;
	
	/**
	 * This method constructs the companions.
	 * @param fName The first name of the companion
	 * @param lName The Last name of the companion
	 * @param p Who the companions belongs to
	 */
	public Companion(String fName, String lName,Person p) {
		this.p = p;
		this.fName = fName;
		this.lName = lName;
	}
	
	/**
	 * Finds who the companions belong to
	 * @return
	 */
	public String whoIsMyPerson() {
		return p.getName();
	}
}
