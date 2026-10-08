package EsameCAD;
public class Licenza {
    String tipo;
    int ID;
    public Licenza(String t,int id){
        if(!t.equals("pro") || !t.equals("base")) return;
        this.tipo =t;
        this.ID=id;
    }

}