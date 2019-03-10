package rmi.server;

import java.rmi.*;
import javax.naming.*;


public class RmiClient {
    public static void main(String[] args) throws NamingException, RemoteException {
      Context namingContext = new InitialContext();
      
      System.out.print("RMI registry bindings: ");
        NamingEnumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
        while (e.hasMore())
            System.out.println(e.next().getName());
      
      String url = "rmi://localhost/order_shipper";
      OrderShipper orderShipper = (OrderShipper) namingContext.lookup(url);
      RmiOrder temp = new RmiOrder("Lucy", " ", " ", 1, 20, 20);
      String str = orderShipper.shipOrder(temp);
      
      System.out.println(str);
   }
}
