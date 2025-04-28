import ReverseModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class StringReverseServer {
    public static void main(String args[]) {
        try {
            // Initialize ORB
            ORB orb = ORB.init(args, null);

            // Get reference to RootPOA & activate it
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create servant and register it
            StringReverseImpl reverseImpl = new StringReverseImpl();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(reverseImpl);
            StringReverse href = StringReverseHelper.narrow(ref);

            // Get Naming Service reference
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Bind the Object Reference in Naming
            NameComponent path[] = ncRef.to_name("StringReverse");
            ncRef.rebind(path, href);

            System.out.println("Server ready and waiting...");

            // Wait for invocations
            orb.run();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}

