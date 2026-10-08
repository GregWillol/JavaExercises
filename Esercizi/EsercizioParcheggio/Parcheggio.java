package EsercizioParcheggio;
public class Parcheggio{
    String posti[] =  {"vuoto","vuoto"};
    int posti_occupati = 0 ;

    public synchronized void entra(String nome)throws InterruptedException{
        while (this.posti_occupati == 2){
            wait();
        } 
         
            for (int i = 0 ; i < 2 ; i++){
                if(this.posti[i].equals("vuoto")){
                    this.posti[i] = nome;
                    System.out.println(nome+" sta entrando dal parcheggio , rimangono : " + Math.abs(this.posti_occupati-2) + " posti.");    
        
                    this.posti_occupati++;
                    break;
                }
            }
        
    }
    public synchronized void esce(){
        if(this.posti_occupati > 0){
            String CheEsce = null;
            this.posti_occupati--;
            notifyAll();
            for(int i = 1 ; i >= 0 ; i--){
                if(!this.posti[i].equals("vuoto")){
                    CheEsce=this.posti[i];
                    this.posti[i] = "vuoto";
                    break;
                }
            }
            System.out.println(CheEsce+" sta uscendo dal parcheggio , rimangono : " + this.posti_occupati + " auto.");    
        }
        else return;
    }

}