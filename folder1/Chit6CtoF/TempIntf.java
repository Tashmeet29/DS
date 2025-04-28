import java.rmi.*;

public interface TempIntf extends Remote {
	double ctof(double celcius) throws RemoteException;
}


