import java.rmi.*;
import java.rmi.server.*;

public class AddServerimpl extends UnicastRemoteObject implements AddServerintf {
	public AddServerimpl() throws RemoteException {
	       super();
	}
	
	public double add(double d1, double d2) throws RemoteException {
		return d1 + d2;
	}
	
	public static void main(String args[]) {
		try {
			AddServerimpl addServerimpl = new AddServerimpl();
			Naming.rebind("AddServer", addServerimpl
