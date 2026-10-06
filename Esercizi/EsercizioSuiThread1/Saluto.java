public class Saluto extends Thread{
    String testo;
    public Saluto(String nome){
        this.testo = nome;
    }
    @Override
    public void run(){
        try{
            System.out.println(this.testo + ": inizio");
            Thread.sleep(500);
            System.out.println(this.testo + ": fine");
        }
        catch(InterruptedException e){

        }

    }
}