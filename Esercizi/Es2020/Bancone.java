public class Bancone{
    private String ingrediente = "vuoto";
    
    public synchronized void deposita(String ing) throws InterruptedException{
        
        while(!this.ingrediente.equals("vuoto")){
            wait();
            
        }
        this.ingrediente = ing;
        notifyAll();
    }
    public synchronized String prendi(String richiesto) throws InterruptedException{
        while(this.ingrediente.equals("vuoto") || (!richiesto.equals("qualsiasi") && !this.ingrediente.equals(richiesto))){
            wait();
        }
        String preso = this.ingrediente;
        this.ingrediente = "vuoto";
        notifyAll();
        return preso;
    }

}

