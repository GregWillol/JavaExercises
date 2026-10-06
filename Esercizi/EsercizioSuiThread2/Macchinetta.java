package EsercizioSuiThread2;
public class Macchinetta {
    String persona; //io credo che sia meglio metterla cosi` 
    // visto che la puo` usare solo una persona alla volta senza rischiare errori collaterali
    public Macchinetta(){
        this.persona = "Nessuno";
    }
    public synchronized void prendiCaffe (String nome)throws InterruptedException{
        while(!this.persona.equals("Nessuno")){
            wait();
        }
        try{
            this.persona = nome;
            System.out.println(this.persona + " sta prendendo il caffe` ADESOOOSOSOSO !!!!!!!");
            Thread.sleep(1000);
            System.out.println(this.persona + " ha finito");
            this.persona = "Nessuno";
        }
        catch(InterruptedException e){

        }
    }

}
