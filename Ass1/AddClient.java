import java.rmi.*;

public class AddClient {
	public static void main(String args[]) {
		try{
			String addServerURL = "rmi://localhost/AddServer";
			AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
			
			double d1 = 8.0;
			double d2 = 9.0;
			double sum = addServerIntf.add(d1, d2);
			
			System.out.println("The first number is: "+d1);
			System.out.println("The second number is: "+d2);
			System.out.println("The sum is: "+sum);
		} catch(Exception e) {
		System.out.println("Exception:"+e);
		}
	}
}			
