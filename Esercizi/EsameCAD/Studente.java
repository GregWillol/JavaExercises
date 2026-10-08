package EsameCAD;

public class Studente extends Thread {
    Licenza licenza;
    public Studente(Licenza lic){
        this.licenza = lic;
    }

    @Override 
    public void run(){
        String randID = (int)Math.floor(Math.random()*2) <= 1? "base" : "pro";
        
    }
    
}
