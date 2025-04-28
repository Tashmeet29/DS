// CaseChangeClient.java
import org.omg.CORBA.*;
import CaseChangeModule.*;

public class CaseChangeClient {
    public static void main(String[] args) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Obtain reference to the remote object from the Naming Service
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(obj);
            StringOperations stringOperations = StringOperationsHelper.narrow(ncRef.resolve_str("StringOperations"));

            // Call the remote method to change string case to upper
            String input = "hello corba";
            String result = stringOperations.toUpperCase(input);
            System.out.println("Original String: " + input);
            System.out.println("Uppercase String: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

