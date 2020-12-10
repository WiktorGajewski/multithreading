import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server extends UnicastRemoteObject implements Calculator {
    public Server() throws RemoteException {}

    public String sayHello() {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
        String response="Hello! || Lab14 ||";
        return response;
    }

    public Double add(double a, double b){
        return a+b;
    }

    public Double sub(double a, double b){
        return a-b;
    }

    public Double mul(double a, double b){
        return a*b;
    }

    public Double div(double a, double b){
        return a/b;
    }

    public Double pow2(double a){
        return a*a;
    }

    public Double sqrt2(double a){
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        try{
            Server obj = new Server();
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Calculator",obj);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
