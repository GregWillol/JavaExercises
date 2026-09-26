public class Main {
    public static void main(String[] args) {
        int width = 800;
        int height  = 600;
        //- - - Declaring the thread game - - - 
        Game game = new Game(width,height,"Engine");
        game.start();

    }
}