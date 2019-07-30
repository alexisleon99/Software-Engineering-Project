import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class FlightTest {

	@Test
	void testlists() throws IOException, ParseException {
		String airline = "delta", answer = "yes",name = "alex",ssn = "222";
		double budget = 10000,cost =7000; 
		Flight p1 = new Flight(airline,name,ssn,budget);
		HashMap locations = new HashMap();
		p1.addCompanion(airline,budget,locations,answer,cost);
		findFile("reservation2221.txt",src);
		//lists("delta");
	}
    public void findFile(String name,File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                findFile(name,fil);
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
                System.out.println(fil.getParentFile());
            }
        }
    }
}
