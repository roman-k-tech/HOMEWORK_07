package TASK_01;

import java.util.Random;

/**
 * Created by Роман on 02.11.2017.
 */
public class Ship implements Runnable {
    Box[] boxes = new Box[10];
    int shipID;
    private Dock dock1, dock2;

    public Ship(int shipID, Dock dock1, Dock dock2) {
        this.shipID = shipID;
        this.dock1 = dock1;
        this.dock2 = dock2;
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new Box(shipID, i);
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        for (Box box : boxes) {
            if (random.nextBoolean()) {
                try {
                    dock1.addBox(box);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    dock2.addBox(box);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
