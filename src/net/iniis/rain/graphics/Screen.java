package net.iniis.rain.graphics;

public class Screen {

    private int counter;
    private int time;

    private int width, height;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void clear() {

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void render() {
        /*
        Use of counter & time to animate the pixels colorisation, and show the necessity to clear the screen
         */
        counter++;
        if (counter % 100 == 0) {
            time++;
        }
        /*
        Loops that moves through every pixels of the array
         */
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[time + time * width] = 0xFF00FF;

            }
        }
    }
}
