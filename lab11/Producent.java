public class Producent extends Thread{
    Platforma platforma;
    int idElementu;
    public Producent(Platforma platforma){
        this.platforma=platforma;
        this.idElementu=1;
    }

    public void run(){

        try {
            while(true){
                Thread.sleep(100);
                System.out.println("Wyprodukowano: Element "+idElementu);
                platforma.postawElement("Element "+idElementu);
                idElementu++;
            }
        }catch (InterruptedException err){}
    }
}
