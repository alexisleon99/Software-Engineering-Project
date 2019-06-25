
public class Person {
	
	String firstName,lastName;
	int birthDay,ssn;  
	
	public Person() {
	}

 public String getName(String firstName, String lastName) {
	 this.firstName = firstName; 
	 this.lastName = lastName; 
	 String name = firstName + " " + lastName;
	 return name;
 }
 

 public int getBday (int birthDay) {
	 return birthDay; 
 }
 
 public int getSsn (int ssn) {
	 return ssn; 
 }

}


