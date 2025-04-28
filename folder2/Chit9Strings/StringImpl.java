import java.rmi.*;
import java.rmi.server.*;

public class StringImpl extends UnicastRemoteObject implements StringIntf {
	protected StringImpl() throws RemoteException {
		super();
	}
	
	public String getLargestStr(String str1, String str2) throws RemoteException {
		return (str1.compareTo(str2) > 0) ? str1 : str2;
	}
}

