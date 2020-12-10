import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    String sayHello() throws RemoteException;
    Double add(double a,double b) throws  RemoteException;
    Double sub(double a,double b) throws  RemoteException;
    Double mul(double a,double b) throws  RemoteException;
    Double div(double a,double b) throws  RemoteException;
    Double pow2(double a) throws  RemoteException;
    Double sqrt2(double a) throws  RemoteException;
}
