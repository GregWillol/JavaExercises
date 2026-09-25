public class Fornitore implements Runnable {
     private String[] ingredienti = {"latte", "caffe"};
     int i = 0;
    private Bancone bancone; 

    public Fornitore (Bancone bancone){
        this.bancone = bancone; 
    }
    public void run(){
        while(true){
            
            
            try{
                System.out.println("Fornitore: sto portando il " + ingredienti[i]);
                bancone.deposita(ingredienti[i]);
                if(ingredienti[i].equals("latte")){
                    i = 1;
                }
                else {
                    i=0;
                }

                
            }
            catch(InterruptedException e){
                break;
            }
        }
       

        
    }

}