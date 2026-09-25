public class Contatore extends Thread{

    String nome;
    // costruttore public perche` immagino che debba essere "visto" in ogni parte del codice 
    public Contatore(String str){
        this.nome = str;
        // serve percaso return???
    }
    @Override //non so cosa faccia sincero
    public void run(){
        try{
            for (int i = 0; i < 3 ; i++){
                System.out.println(this.nome+": passo "+ i);
                Thread.sleep(200);
            }

        }
        catch(InterruptedException e){
        }
    }
} 