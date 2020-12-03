import java.util.concurrent.Semaphore;

public class Widelec {
    private Semaphore semaphore;
    public Widelec(){
        semaphore=new Semaphore(1);
    }

    public void podniesWidelec(){
        semaphore.acquireUninterruptibly();
    }
    public void odlozWidelec(){
        semaphore.release();
    }
}
