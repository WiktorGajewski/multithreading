import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {}

    static Scanner in=new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(null);
            Calculator stub = (Calculator) registry.lookup("Calculator");
            String response = stub.sayHello();
            System.out.println(response);

            String value="0";

            while(!(value.equals("q"))){
                double a=0.0;
                double b=0.0;
                double result=0.0;
                System.out.println("Rodzaje dzialania:");
                System.out.println("1. Dodawanie\n2. Odejmowanie\n3. Mnozenie");
                System.out.println("4. Dzielenie\n5. Potega\n6. Pierwiastek");
                System.out.println("Podaj cyfre dzialania i nacisnij enter");
                System.out.println("Jesli chcesz zakonczyc podaj q");

                value=in.next();

                switch(value)
                {
                    case "1":
                        System.out.print("Podaj pierwsza liczbe: ");
                        a=in.nextDouble();
                        System.out.print("Podaj druga liczbe: ");
                        b=in.nextDouble();
                        System.out.print("Wynik: ");
                        result = stub.add(a,b);
                        System.out.println(result+"\n");
                        break;
                    case "2":
                        System.out.print("Podaj pierwsza liczbe: ");
                        a=in.nextDouble();
                        System.out.print("Podaj druga liczbe: ");
                        b=in.nextDouble();
                        System.out.print("Wynik: ");
                        result = stub.sub(a,b);
                        System.out.println(result+"\n");
                        break;
                    case  "3":
                        System.out.print("Podaj pierwsza liczbe: ");
                        a=in.nextDouble();
                        System.out.print("Podaj druga liczbe: ");
                        b=in.nextDouble();
                        System.out.print("Wynik: ");
                        result = stub.mul(a,b);
                        System.out.println(result+"\n");
                        break;
                    case  "4":
                        System.out.print("Podaj pierwsza liczbe: ");
                        a=in.nextDouble();
                        System.out.print("Podaj druga liczbe: ");
                        b=in.nextDouble();
                        System.out.print("Wynik: ");
                        result = stub.div(a,b);
                        System.out.println(result+"\n");
                        break;
                    case "5":
                        System.out.print("Podaj pierwsza liczbe: ");
                        a=in.nextDouble();
                        System.out.print("Wynik: ");
                        result = stub.pow2(a);
                        System.out.println(result+"\n");
                        break;
                    case "6":
                        System.out.print("Podaj pierwsza liczbe: ");
                        a=in.nextDouble();
                        System.out.print("Wynik: ");
                        result = stub.sqrt2(a);
                        System.out.println(result+"\n");
                        break;
                }
            }

            System.out.println("Goodbye");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
