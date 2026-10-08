package EsameYFactor;

public class Studio {
    Cantante[] camerini;
    int camerini_occupati;
    int n;
    String palco;
    int Artisti;
    int counter;
    
    public Studio(int n,int artisti){
        this.camerini_occupati=0;
        this.n=n;
        this.counter = 0 ;
        this.Artisti = artisti;
        this.palco = "vuoto";
        this.camerini= new Cantante[n];
        for(int i = 0; i < n; i++){
            this.camerini[i] = new Cantante("vuoto",this);
        }
    }
    public synchronized void prendiCamerino(Cantante cantante) throws InterruptedException{
        while(this.camerini_occupati == this.n){
            wait();
        }

        for(int i = 0 ; i <this.n;i++){
            if(this.camerini[i].nome.equals("vuoto")){
                this.camerini[i].nome= cantante.nome;
                this.camerini[i].entrato = true;
                this.camerini_occupati++;
                System.out.println(cantante.nome + ": entro in camerino.");
                if((int)Math.floor(Math.random()*10)<1){
                    // ha fumato
                    System.out.println(cantante.nome +": si e` fumato una sizza");
                    for(int j = 0 ; j < this.n ;j++){
                        if(!this.camerini[i].nome.equals("vuoto")){
                            
                            cantante.riparte = true;
                        }
                    }
                }
                break;
            }
        }
    }
    public synchronized void lasciaCamerino(Cantante cantante){
        for(int i = 0;i<this.n;i++){
            if(this.camerini[i].nome.equals(cantante.nome)){
                cantante.entrato = false;
                if(cantante.riparte){
                    System.out.println(cantante.nome + "ricomincio da capo.");
                }
                else {
                    System.out.println(cantante.nome + ": esco dal camerino.");
                }
                this.camerini[i].nome = "vuoto";
                this.camerini_occupati--;
                notifyAll();
                break;
            }
        }
    }
    public synchronized void saliPalco(Cantante cantante)throws InterruptedException{
        while(!this.palco.equals("vuoto")){
            wait();
        }
        this.palco = cantante.nome;
        System.out.println(cantante.nome + ": salgo sul palco");
    }
    public synchronized void scendiPalco(){
        
        System.out.println(this.palco + ": scendo dal palco");
        this.palco = "vuoto";
        notifyAll();
        counter++;
        if(this.Artisti == this.counter){
            System.out.println("FINE");
        }
    }
}
