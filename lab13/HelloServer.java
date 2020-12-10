import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloServer extends UnicastRemoteObject implements Hello {
    public HelloServer() throws RemoteException {}

    public String sayHello() {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");
        String response="Hello! Today is "+dateFormat.format(date)+"\nLab13";
        return response;
    }

    public static void main(String[] args) {
        try{
            HelloServer obj = new HelloServer();
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello",obj);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
