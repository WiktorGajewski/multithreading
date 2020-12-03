public class Konsument extends Thread{
    Platforma platforma;
    public Konsument(Platforma platforma){
        this.platforma=platforma;
    }

    public void run(){
        String element="";

        try {
            while (true)
            {
                Thread.sleep(100);
                element=platforma.zabierzElement();
                System.out.println("Konsument ma: "+element);
            }
        }catch (InterruptedException err){}
    }
}
