package EsameYFactor;

public class YFactor {
    public static void main(String[] args) {
        Studio studio = new Studio(2,4);
        Cantante a = new Cantante("SapoBully", studio);
        Cantante b = new Cantante("SonLas5DeLaManana", studio);
        Cantante c = new Cantante("Genitalz", studio);
        Cantante d = new Cantante("Munafo", studio);
        a.start();
        b.start();
        c.start();
        d.start();

        
    }
    
}
