package EsameYFactor;

public class Cantante extends Thread {
    String nome;
    boolean ha_performato = false;
    boolean entrato = false; 
    boolean riparte = false;
    Studio studio;
    public Cantante(String n,Studio y){
        this.nome = n ; 
        this.studio = y;
    }
    @Override 
    public void run(){
        try{
            while(!this.ha_performato){
            this.studio.prendiCamerino(this);
            int randomTime=(int)(Math.floor(Math.random()*1000));
            System.out.println(this.nome+": mi preparo in camerino per "+randomTime+" ms.");
            Thread.sleep(randomTime);
            
            if(this.riparte){
                this.studio.lasciaCamerino(this);
                this.riparte = false;
                continue;
            }
            this.studio.lasciaCamerino(this);
            

            this.studio.saliPalco(this);
            randomTime=(int)(Math.floor(Math.random()*1000));
            System.out.println(this.nome+": performo sul palco per "+randomTime+" ms.");
            Thread.sleep(randomTime);
            this.studio.scendiPalco();
            this.ha_performato = true;
            }
        }
        catch(InterruptedException e){

        }
        
    }



    
}
