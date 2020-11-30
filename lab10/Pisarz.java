public class Pisarz extends Thread{
    private int idPisarza;
    private Ksiazka[] listaKsiazek;
    public Pisarz(int id, Ksiazka[] listaKsiazek){
        idPisarza=id;
        this.listaKsiazek=listaKsiazek;
    }

    public void run()
    {
        try{
            for(int i=0;i<100;i++){
                Thread.sleep((int)(Math.random()*3000.0));  //czas pisania ksiazki

                listaKsiazek[i+idPisarza*100].pisanie();
                System.out.println("#Napisano ksiazke o id ksiazki: "+listaKsiazek[i+idPisarza*100].id()+
                        " Id pisarza: "+idPisarza);
            }

        }catch(InterruptedException err) {
            System.out.println("Problem z napisaniem ksiazki!!");
        }

    }
}
