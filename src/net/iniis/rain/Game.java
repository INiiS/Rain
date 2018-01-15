package net.iniis.rain;

import javax.swing.JFrame;
import java.awt.*;

/*
    Runnable makes sure the thread contains the game object.
 */
public class Game extends Canvas implements Runnable {

    /*
    Defines the resolution of the game, with a scale so it can be scaled up in the future.
    The height is defined relative to the width so that the ratio can be changed (here 16:9).
     */
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

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

    @Override
    /*
    Implementation of Runnable.run()
    Main "game loop", so that our game runs after the 1st frame.
    Without this loop, the game would stop after the 1st frame would have been rendered.
     */
    public void run() {

        while (running) {

        }
    }

    public static void main(String[] args){
        Game game = new Game();
    }
}
