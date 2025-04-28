import java.rmi.*;

public class VowelsServer {
	public static void main(String[] args) {
		try {
			VowelsImpl obj = new VowelsImpl();
			Naming.rebind("VowelsServer", obj);
			System.out.println("Vowels count Server is ready...");
		}  catch (Exception e) {
			System.out.println("Server Error" + e.getMessage());
		} 
	}
}
