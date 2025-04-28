// CaseChangeServer.java
import org.omg.CORBA.*;
import CaseChangeModule.*;

public class CaseChangeServer {
    public static void main(String[] args) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Create servant and register it with ORB
            StringOperationsImpl servant = new StringOperationsImpl();
            org.omg.CORBA.Object ref = orb.resolve_initial_references("NameService");

            // Register the object with the Naming Service
            NamingContextExt ncRef = NamingContextExtHelper.narrow(ref);
            NameComponent path[] = ncRef.to_name("StringOperations");
            ncRef.rebind(path, servant);

            System.out.println("CaseChangeServer ready and waiting...");
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

