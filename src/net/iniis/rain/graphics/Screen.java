package net.iniis.rain.graphics;

import java.util.Random;

public class Screen {

    private int width, height;
    public int[] pixels;
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void render(int xOffset, int yOffset) {

        /*
        Loops that moves through every pixels of the array
         */
        for (int y = 0; y < height; y++) {
            int yy = y + yOffset;
            //if (yy < 0 || yy >= height) break;
            for (int x = 0; x < width; x++) {
                int xx = x + xOffset;
                //if (xx < 0 || xx >= width) break;
                /*
                find the correct tile for a coordinate
                Uses offsets + xx & yy to simulate moving through the map.
                 */
                int tileIndex = ((xx / 16) & MAP_SIZE_MASK) + ((yy / 16) & MAP_SIZE_MASK) * MAP_SIZE;
                pixels[x + y * width] = tiles[tileIndex];

            }
        }
    }
}
