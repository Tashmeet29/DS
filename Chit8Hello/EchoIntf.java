import java.rmi.*;

public interface EchoIntf extends Remote {
	String sayHello(String name) throws RemoteException;
}


