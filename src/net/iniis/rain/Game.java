package net.iniis.rain;

import javax.swing.JFrame;
import java.awt.*;

/**
 * Projet tutorial Rain.
 * Tutorial original "Game Programming" par TheChernoproject : https://www.youtube.com/playlist?list=PLlrATfBNZ98eOOCk2fOFg7Qg5yoQfFAdf
 */


public class Game extends Canvas implements Runnable {
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
    public void run() {

        while (running) {

        }
    }

    public static void main(String[] args){
        Game game = new Game();
    }
}
