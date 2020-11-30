public class Czytelnik extends Thread{
    private int idCzytelnika;
    private Ksiazka[] listaKsiazek;
    public Czytelnik(int id,Ksiazka[] listaKsiazek){
        idCzytelnika=id;
        this.listaKsiazek=listaKsiazek;
    }

    public void run()
    {
        try{

            for(int i=0;i<listaKsiazek.length;i++)
            {
                listaKsiazek[i].czytanie();

                System.out.println("-Przeczytano ksiazke o id ksiazki: "+listaKsiazek[i].id()+
                        " Id czytelnika: "+idCzytelnika);
            }

        }catch(Exception err){
            System.out.println("Problem z przeczytaniem ksiazki!!");
        }
    }
}
