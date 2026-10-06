package EsercizioSuiThread2;
public class Main{
    Macchinetta m = new Macchinetta();
        Collega c1 = new Collega(m, "paolo");
        Collega c2 = new Collega(m, "elia");
        Collega c3 = new Collega(m, "carlo");
    public void main(){
        
        c1.start();
        c2.start();
        c3.start();
    }
}