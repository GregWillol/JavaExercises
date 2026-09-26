import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Game implements Runnable {
    private boolean isExe = false;
    private Thread gameThread;
    private int width;
    private int height;
    private String name;

    private Canvas c;
    private JFrame window;

    long lastTime = System.nanoTime();         
    double nsPerTick = 1000000000.0 / 60.0;    
    double delta = 0;                          

    public Game(int wid, int hei, String str){
        this.width = wid;
        this.height = hei;
        this.name=str;
        this.c = new Canvas();
        this.window = new JFrame(this.name);
    }

    public synchronized void start(){
        if(this.isExe){
            return;
        }
        else{
            this.isExe = true;
            this.gameThread = new Thread(this);
            this.gameThread.start();
        }
    }
    private void init(){
        // - - - window settings - - -
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // - - - canvas settings - - - 
        c.setPreferredSize(new Dimension(width, height));
        c.setBackground(Color.BLACK);
        
        window.add(c);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        // Triple buffering per evitare sfarfallii
        c.createBufferStrategy(3);
    }
    private void tick(){

    }
    private void render(){
        BufferStrategy bs = this.c.getBufferStrategy();

        if (bs == null){
            this.c.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        // - - - start drawing - - -
        
        // cleaning canvas
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.width, this.height);

        g.setColor(Color.RED);
        g.fillArc(this.width/2-100, this.height/2-100, 200, 200, 0, 360);

        g.dispose();
        bs.show();

    }
    
    public void run(){
        init();
        // - - -  Calculating the Delta Time between every 2 ticks - - - 
        
        long lastTime = System.nanoTime();
        while(this.isExe){
            long now = System.nanoTime();
            long elapsed = now - this.lastTime;
            this.lastTime = now ;
            delta += elapsed /nsPerTick;

            while(delta >=1){
                tick();
                delta--;
            }
            System.out.println("Per ora funziona");
            render();
        }
    }
    
}
