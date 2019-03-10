package rmi.server;

import java.rmi.*;


public interface OrderShipper extends Remote
{  
   String shipOrder(RmiOrder order) throws RemoteException;
}
