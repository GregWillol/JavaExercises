public class Paziente{
    public enum Codice{
        BIANCO,
        GIALLO,
        ROSSO
    }; 
    String nome; 
    Codice codice;
    public Paziente(String str, Codice cod){
        this.nome = str; 
        this.codice = cod;
    }
    public boolean haPrecedenzaSu(Paziente other){
        //faccio la preallocazione non so se ha senso ma in teoria si` lol
        int CodicePaziente1 = this.codice.ordinal();
        int CodicePaziente2 = other.codice.ordinal(); //metto ordinal senno` mi da una stringa

        if(CodicePaziente1 < CodicePaziente2){ // significa che il primo non ha precedenza rispetto al secondo
            System.out.println("Questo Paziente non ha precedenza sull'Altro");
        }
        else if(CodicePaziente1 == CodicePaziente2){ // significa che il primo  ha la stessa precedenza rispetto al secondo
            System.out.println("Questo Paziente ha la stessa precedenza sull'Altro");
        }
        if(CodicePaziente1 > CodicePaziente2){ // significa che il primo  ha precedenza rispetto al secondo
            System.out.println("Questo Paziente ha precedenza sull'Altro");
        } // manca il return e da errore perche` non e` void il metodo ma boolean

        /*public boolean haPrecedenzaSu(Paziente other) {
            return this.codice.ordinal() > other.codice.ordinal();
            } 
        */
    }   




}