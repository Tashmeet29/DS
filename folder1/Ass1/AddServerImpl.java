import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf {
	public AddServerImpl() throws RemoteException {
	       super();
	}
	
	public double add(double d1, double d2) throws RemoteException {
		return d1 + d2;
	}
	
	public static void main(String args[]) {
		try {
			AddServerImpl addServerImpl = new AddServerImpl();
			Naming.rebind("AddServer", addServerImpl);
			System.out.println("AddServer is ready");
		} catch(Exception e) {
		        System.out.println("Exception:"+e);
		}
	}
}
