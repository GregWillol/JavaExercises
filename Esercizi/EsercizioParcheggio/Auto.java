package EsercizioParcheggio;

public class Auto extends Thread{
    String nome;
    Parcheggio parcheggio;
    public Auto(String str, Parcheggio p){
        this.nome = str;
        this.parcheggio = p;
    }
    @Override 
    public void run(){
        try{
            this.parcheggio.entra(this.nome);
            Thread.sleep(5000);
            this.parcheggio.esce();
        }
        catch(InterruptedException e){

        }
    }
}
