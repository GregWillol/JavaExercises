package EsercizioParcheggio;

public class Main {
    public void main(String[] args){
        Parcheggio p = new Parcheggio();
        Auto a = new Auto("BMW E36", p);
        Auto b = new Auto("Mitsubishi Evo", p);
        Auto c = new Auto("Nissan Skyline", p);
        Auto d = new Auto("Toyota Supra", p);
        a.start();
        b.start();
        c.start();
        d.start();
    }
    
}
