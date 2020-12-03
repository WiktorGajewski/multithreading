import java.util.concurrent.Semaphore;

public class Filozof extends Thread{
    private int idFilozofa;
    private Widelec[] widelec;
    private static Semaphore ograniczenie;
    public Filozof(int id,Widelec[] widelec,Semaphore ograniczenie){
        idFilozofa=id;
        this.widelec=widelec;
        this.ograniczenie=ograniczenie;
    }

    public void run(){
        try{
            for(int i=0;i<100;i++){

                ograniczenie.acquireUninterruptibly();  //ograniczenie liczby jedzacych filozofow

                widelec[idFilozofa].podniesWidelec();                       //podnosi lewy widelec
                widelec[(idFilozofa+1)% widelec.length].podniesWidelec();   //podnosi prawy widelec

                System.out.println("Zaczyna jesc. Filozof "+idFilozofa);
                Thread.sleep((long)(100*Math.random()));
                System.out.println("Konczy jesc. Filozof "+idFilozofa);

                widelec[idFilozofa].odlozWidelec();                         //odklada lewy widelec
                widelec[(idFilozofa+1)% widelec.length].odlozWidelec();     //odklada prawy widelec

                ograniczenie.release();                 //miejsce zwolnione
            }
        }catch(InterruptedException err){}
    }
}
