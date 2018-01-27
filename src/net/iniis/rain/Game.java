package net.iniis.rain;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferStrategy;

/*
    Runnable makes sure the thread contains the game object.
 */
public class Game extends Canvas implements Runnable {


    /*
    Defines the resolution of the game, with a scale so it can be scaled up in the future.
    The height is defined relative to the width so that the ratio can be changed (here 16:9).
     */
    private static final long serialVersionUID = 1L;

    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    public Game() {
        /*
        Settings of window size, and creation of game window object.
         */
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size); //applying size setting to window

        frame = new JFrame();
    }

    /*
    synchronized keyword ensures there is no overlaps of instructions for this thread.
    An overlap could cause crashes or lockdowns.
     */
    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();

    }


    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /*
    Implementation of Runnable.run()
    Main "game loop", so that our game runs after the 1st frame.
    Without this loop, the game would stop after the 1st frame would have been rendered.
     */
    public void run() {

        while (running) {
            update(); //logic of the game - 60 FPS
            render(); // images of the game - unrestricted

        }
    }

    /*
    Logic of the game, runs at 60 FPS max.
     */
    public void update(){

    }

    /*
    Rendering method, unrestricted FPS.
     */
    public void render(){

        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics(); //getDrawGraphics create link between graphics and the buffer strategy
        //Graphics to be displayed have to be between the above line and the g.dispose()
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
        g.dispose(); // disposes the current graphics, release the system resources.
        bs.show();
    }

    public static void main(String[] args){
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Rain");
        game.frame.add(game);
        game.frame.pack(); //size the frame the same as the component it contains
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null); //center the  window
        game.frame.setVisible(true); // VERY IMPORTANT : on false, window cannot be seen

        game.start();
    }
}
