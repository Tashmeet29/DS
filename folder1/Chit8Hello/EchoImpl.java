import java.rmi.*;
import java.rmi.server.*;

public class EchoImpl extends UnicastRemoteObject implements EchoIntf {
	protected EchoImpl() throws RemoteException {
		super();
	}
	
	public String sayHello(String name) throws RemoteException {
		return "Hello " + name;
	}
}

