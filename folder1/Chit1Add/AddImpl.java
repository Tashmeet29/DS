import java.rmi.*;
import java.rmi.server.*;

public class AddImpl extends UnicastRemoteObject implements AddIntf {
	protected AddImpl() throws RemoteException {
		super();
	}
	
	public int add(int a, int b) throws RemoteException {
		return a + b;
	}
}

