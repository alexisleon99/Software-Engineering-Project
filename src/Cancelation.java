import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Cancelation extends Login {
	static Scanner input = new Scanner(System.in);
	public static void cancel(String ssn) throws IOException {
		File f1=new File("reservations"+ssn+".txt");
		String[] words=null;
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String s;     
		String input=ssn;
		int count=0;
		while((s=br.readLine())!=null){
			words=s.split("\t");
		    //words=s.split(" "); 
		    for (String word : words) {
		    	if (word.equals(input)) {
		    		count++;
		        }
		    }
		}
		if(count!=0) {
			System.out.println("Ahh your SSN was found we will cancel per your request"); 
		    System.out.println("Refund will begin soon, than you for your service"); 
		}
		else{
			System.out.println("Sorry Sir/Mam you do not currently have a reservation with us");
		}
		br.close();
	}
	
	public static void reschedule(String ssn) throws java.text.ParseException, IOException {
		File fileToBeModified = new File("reservations"+ssn+".txt");
	    String oldContent = "";
	    BufferedReader reader = null;
	    FileWriter writer = null;
	    try{
	    	reader = new BufferedReader(new FileReader(fileToBeModified));
	        String line = reader.readLine();
	        while (line != null) {
	        	oldContent = oldContent + line + System.lineSeparator();
	            line = reader.readLine();
	        }
	        System.out.println("Enter in old departure in this format dd-M-yyyy hh:mm:ss");
	        String oldDeparture = input.nextLine();
	        System.out.println("Enter in new departure in this format dd-M-yyyy hh:mm:ss");
	        String newDeparture = input.nextLine();
	        String newContent = oldContent.replaceAll(oldDeparture, newDeparture);
	        writer = new FileWriter(fileToBeModified); 
	        writer.write(newContent);
	    }
	    catch (IOException e){
	    	e.printStackTrace();
	    }finally{
	    	try{
	    		reader.close();     
	            writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }	
	}
	
	public static void refund(String ssn) throws IOException {
		File f1=new File("reservations"+ssn+".txt");
		String[] words=null;
		FileReader fr = new FileReader(f1);
		BufferedReader br = new BufferedReader(fr);
		String s;
		while((s=br.readLine())!=null){
			words=s.split(" ");
			for(int i = 0; i < words.length;i++) {
				if(words[i].equals("$")) {
					String refund = words[i+1];
					System.out.println("We found your Reservation ticket we will now is your refund (check refund ticket with your ssn)");
					String filename = "Refund"+ssn+".txt";
					PrintWriter outputStream = null;
					try {
						outputStream = new PrintWriter(filename);
						outputStream.println("**Refund***\n" + "Were sorry to see you go here is your refund of "+ refund);
						outputStream.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					String clear = "reservations"+ssn+".txt";
					PrintWriter outputStream2 = null;
					try {
						outputStream2 = new PrintWriter(clear);
						outputStream2.println();
						outputStream2.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}	
				}
			}
		}
		br.close();
	}
}
