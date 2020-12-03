
public class Lab11 {
    public static void main(String[] args) {
        Platforma platforma=new Platforma();
        Producent producent=new Producent(platforma);
        Konsument konsument=new Konsument(platforma);

        producent.start();
        konsument.start();

        try{
            Thread.sleep(1000);
        }catch (Exception err){}

        producent.interrupt();
        konsument.interrupt();
    }
}
