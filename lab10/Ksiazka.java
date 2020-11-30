public class Ksiazka {
    private boolean dostepnoscKsiazki=false;    //ksiazka dostepna:     true
                                                //ksiazka niedostepna:  false
    private int idKsiazki;

    public Ksiazka(int id){
        idKsiazki=id;
    }

    public int id() {
        return idKsiazki;
    }

    public synchronized void pisanie()
    {
        dostepnoscKsiazki=true;     //ksiazka zostala napisana - staje sie dostepna

        notifyAll();                //powiadom inne watki
    }

    public synchronized void czytanie()
    {
        while(!dostepnoscKsiazki)   //jesli dostepnoscKsiazki == false
        {
            try{
                wait();     //watek uspiony
            }catch(InterruptedException e){}
        }

        dostepnoscKsiazki=false;    //ksiazka niedostepna - jest w trakcie czytania

        try{
            Thread.sleep((int)(Math.random()*3000.0));  //czas czytania ksiazki
        }catch(InterruptedException err){}              //


        dostepnoscKsiazki=true;     //ksiazka znowu jest dostepna

        notifyAll();                //powiadom inne watki
    }
}
