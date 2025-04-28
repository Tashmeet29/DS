import java.rmi.*;

public interface StringIntf extends Remote {
	String getLargestStr(String str1, String str2) throws RemoteException;
}


