
public class lab10 {

    public static void main(String[] args) {


        int x=5;   //liczba Pisarzy
        int y=4;   //liczba Czytelnikow

        Pisarz[] pisarzTab = new Pisarz[x];
        Czytelnik[] czytelnikTab = new Czytelnik[y];
        Ksiazka[] ksiazkaTab=new Ksiazka[x*100];


        for(int i=0;i<(x*100);i++){
            ksiazkaTab[i]=new Ksiazka(i);
        }
        for(int i=0;i<x;i++){
            pisarzTab[i]=new Pisarz(i,ksiazkaTab);
        }
        for(int i=0;i<y;i++){
            czytelnikTab[i]=new Czytelnik(i,ksiazkaTab);
        }



        for (int i=0;i< pisarzTab.length;i++){
            pisarzTab[i].start();
        }

        for (int j=0;j< czytelnikTab.length;j++){
            czytelnikTab[j].start();
        }

    }
}
