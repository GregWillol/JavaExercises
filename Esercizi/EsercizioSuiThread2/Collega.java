package EsercizioSuiThread2;

public class Collega extends Thread{
    private String nome;
    private Macchinetta macchinetta;
    public Collega(Macchinetta m, String n){
        this.nome = n;
        this.macchinetta = m;
    }
    @Override
    public void run(){
        try{
            this.macchinetta.prendiCaffe(this.nome);
        }
        catch(InterruptedException e){
            
        }
    }
        
    
}
