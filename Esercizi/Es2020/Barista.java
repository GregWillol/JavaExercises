public class Barista implements Runnable {
     String[] necessari = {"latte", "caffe"}; 
     int presi = 0; 

     private Bancone bancone; 
     private Fornitore fornitore;
     public Barista (Bancone bancone, Fornitore fornitore){
        this.bancone = bancone;
        this.fornitore = fornitore;

     }
     public void run(){
        while(true){
           try{
                if (presi == 0){
                    String preso = bancone.prendi("qualsiasi");
                }
               for (int j = 0; j < necessari.length ; j++){
                int k = !necessari[j].equals(null) ? j : 0;
                if (necessari[k] != null && necessari[k].equals(preso)){
                    necessari[k] = null;
                }
                presi++;
               
               }
               if(presi == 2){
                   System.out.println("CAPPPUCCINO PRONTOOOOOOOO");
                   presi = 0;
                   necessari = new String[] {"latte", "caffe"}; 
                   break;
               }
               
           }
           catch(InterruptedException e){
               break;
           }
        }
     }
} 