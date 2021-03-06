package net.iniis.rain.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[120];
    public boolean up, down, left, right;

    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_Z];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_Q];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
/*
        for (int i = 0; i < keys.length; i++) {
            if (keys[i]) {
                System.out.println("KEY: " + i);
            }
        }*/
    }

    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

    }


    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

    }
}
