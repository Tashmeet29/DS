import java.rmi.*;

public interface AddServerintf extends Remote {
	double add(double d1, double d2) throws RemoteException;
}


