import java.rmi.*;
import java.util.*;

public class VowelsClient {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String serverURL = "rmi://localhost/VowelsServer";
			VowelsIntf vowelsIntf = (VowelsIntf) Naming.lookup(serverURL);
			
			System.out.print("Enter a word: ");
		        String word = sc.nextLine();    
		        
		        System.out.println("--------------- Results ---------------");
		        System.out.println("Number of Vowels in '" + word + "' = " + vowelsIntf.countVowels(word));
		} catch (Exception e) {
			System.out.println("Exception Occurred At Client!" + e.getMessage());
		}
	}
}
