public class Platforma {
    private String element;
    private boolean jestElement=false;

    synchronized void postawElement(String element)   //wykonuje Producent
    {
        while(jestElement){     //jeśli jest element na platformie
            try {
                this.wait();    //czekaj
            }catch (Exception err){ }
        }
        this.element=element;
        System.out.println("Postawiono nowy element na platformie!");
        jestElement=true;       //nowy element postawiono na platformie - dostępny

        notifyAll();            //poinformuj inne wątki
    }
    synchronized String zabierzElement()  //wykonuje Konsument
    {
        while(!jestElement){    //jeśli nie ma elementu na platformie
            try {
                this.wait();    //czekaj
            }catch (Exception err){ }
        }

        System.out.println("Zabrano element z platformy!");
        jestElement=false;       //element został zabrany z platformy - niedostępny

        notifyAll();            //poinformuj inne wątki

        return element;
    }
}
