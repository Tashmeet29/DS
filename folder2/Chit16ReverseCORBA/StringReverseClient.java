import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class StringReverseClient {
    public static void main(String args[]) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get reference to naming service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the object reference
            StringReverse reverseObj = StringReverseHelper.narrow(ncRef.resolve_str("StringReverse"));

            // Call the method
            String input = "HelloCORBA";
            String result = reverseObj.reverseString(input);
            System.out.println("Original: " + input);
            System.out.println("Reversed: " + result);
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace();
        }
    }
}

