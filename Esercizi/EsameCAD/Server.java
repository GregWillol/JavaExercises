package EsameCAD;

public class Server {
    int base;
    Licenza licenze[] = new Licenza[6];
    int pro;
    public Server(){
        for (int i = 0 ; i < 5; i++){
            int id = (int)Math.floor(Math.random()*10000); 
            if(i==0){
                this.pro++;
                this.licenze[i] = new Licenza("pro",id);
            }
            this.base++;
            this.licenze[i+1] = new Licenza("base",id);
        }
    }

    public synchronized void prendi(String tipo) throws InterruptedException{
        
        if (tipo.equals("pro")){
            while(this.pro == 1){
                System.out.println("Abbiamo finito le licenze proteiche lol. aspetta.");
                wait();
            }
            
                pro++;
                System.out.println("Ha preso una licenza proteica.");
            
        }
        else{
            while(this.base == 5){
                System.out.println("Abbiamo finito le licenze base lol. Aspetta.");
                wait();
                
            }
            
                base++;
                System.out.println("Ha preso una licenza base.");
            
        }

    }
    public synchronized void restituisci(Licenza lic){
        if(lic.tipo.equals("pro")){
            this.pro--;
            System.out.println("e` stata restituita una pro, affrettatevi.");
            notifyAll();
        }
        else{
            this.base--;
            System.out.println("e` stata restituita una base, SVEGLIIAAA.");
            notifyAll();
        }
    }
    public synchronized void upgrade(int id) throws LicenzaNonCorrettaException,InterruptedException{
        int trovato = -1;
        for(int i = 0 ; i < 6; i++){
            if(licenze[i].ID == id && !licenze[i].tipo.equals("pro")){
                trovato = i; 
            }
        }
        if(trovato == -1){
            throw new LicenzaNonCorrettaException("sei un pollo broski");
        }
        else {
            while(this.pro>=1){
                System.out.println("stai aspettando una licenza proteica");
                wait();
            }
            licenze[trovato].tipo="pro";
            System.out.println("sei diventato un pro");
        }
        
    }
}
