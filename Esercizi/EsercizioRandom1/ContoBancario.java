public class ContoBancario {
    private int saldo = 0;

    // Metodo 1: versa(int cifra)
    // Deve aggiungere la cifra a saldo in modo thread-safe
    public synchronized void versa(int cifra){
        this.saldo += cifra;
        notifyAll(); // sveglia eventuali thread bloccati dentro preleva()!
    }

    // Metodo 2: getSaldo()
    // Deve restituire il valore di saldo in modo thread-safe
    public synchronized int getSaldo(){
        System.out.println("Il tuo saldo e' : "+this.saldo);
        return this.saldo;
    }
    public synchronized void preleva (int cifra) throws InterruptedException{
        while(this.saldo < cifra){
            wait();
        }
        this.saldo -= cifra;
        
    }
}