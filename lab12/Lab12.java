
import java.util.concurrent.Semaphore;

public class Lab12 {
    public static void main(String[] args) {
        int liczbaFilozofow=5;
        int liczbaWidelcow=5;

        Widelec[] widelec=new Widelec[liczbaWidelcow];
        Filozof[] filozof=new Filozof[liczbaFilozofow];

        int ograniczenieJedzacych=liczbaWidelcow/2; //ograniczenie liczby jedzacych jednoczesnie filozofow
                                                    //ograniczenie=2 dla liczbyWidelcow=5

        Semaphore ograniczenie=new Semaphore(ograniczenieJedzacych,true);

        for(int i=0;i<liczbaWidelcow;i++){
            widelec[i]=new Widelec();
        }
        for(int i=0;i<liczbaFilozofow;i++){
            filozof[i]=new Filozof(i,widelec,ograniczenie);
            filozof[i].start();
        }

    }
}
