public class Autolavaggio{
    String[] piste = {"vuota","vuota"};
    String piazzola = "vuota";
    int pisteOccupate = 0;
    public synchronized void pulizia(String nomeAutomobilista) throws InterruptedException{
        while(this.pisteOccupate == 2){
            wait();
        }
        // deve verificare che almeno una delle 2 piste sia libera
        for(int i = 0 ; i < 2 ; i++){
            if(this.piste[i].equals("vuoto")){
               this.piste[i] = nomeAutomobilista;
               
                this.pisteOccupate++;
               return; 
            }
        }
    }
    public synchronized void asciugatura(String nomeAutomobilista) throws InterruptedException{
        while(!piazzola.equals("vuota")){
            wait();
        }
        
        this.piazzola = nomeAutomobilista;
        this.pisteOccupate--;
        notifyAll();
        
         
    }
    public synchronized void uscitaAsciugatura(String nome){
        this.piazzola = "vuoto";
        notifyAll();
    }
    
}
public class Automobilitsta extends Thread {
    String nome;
    Autolavaggio autolavaggio;
    public Automobilitsta(String str, Autolavaggio autolavaggio){
        this.nome = str;
        this.autolavaggio= autolavaggio;
    }

    @Override
    public void run(){
        try{
            // pulizia
            this.autolavaggio.pulizia(this.nome);
            int TempoRandom = (int)(Math.random()*300)+200
            Thread.sleep(TempoRandom);
            // asciugatura
            this.autolavaggio.asciugatura(this.nome);
             TempoRandom = (Math.random()*100)+200
            Thread.sleep(TempoRandom);
            this.autolavaggio.uscitaAsciugatura(this.nome);
            
        }
        catch(InterruptedException e){

        }
    }
}