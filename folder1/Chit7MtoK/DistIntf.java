import java.rmi.*;

public interface DistIntf extends Remote {
	double mtok(double miles) throws RemoteException;
}


