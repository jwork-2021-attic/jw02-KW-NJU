package S191220109.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Scene {

    public static void main(String[] args) throws IOException {

        Line line = new Line(256);
        boolean[] used = new boolean[256];
        
        for (int i = 0; i < 256; ++i) {
            Random r = new Random();
            int ran1 = r.nextInt(256);
            while (used[ran1]) {
                ran1 = (ran1 + 1) % 256;
            }
            used[ran1] = true;
            Monster g = new Monster(i);
            line.put(g, ran1, i);
        }

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new BubbleSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new
        FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
