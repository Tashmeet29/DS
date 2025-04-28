import java.rmi.*;
import java.rmi.server.*;

public class DivImpl extends UnicastRemoteObject implements DivIntf {
	protected DivImpl() throws RemoteException {
		super();
	}
	
	public double div(double a, double b) throws RemoteException {
		if(b==0) {
			System.out.println("Cannot divide by zero!");
		}
		return a/b;
	}
}

