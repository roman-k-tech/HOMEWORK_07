package TASK_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 02.11.2017.
 */
public class Dock {
    private int boxCount;
    private String dockN;
    private List<Box> boxes = new ArrayList<Box>();

    public Dock(String dockN) {
        this.dockN = dockN;
    }

    public synchronized void addBox(Box box) throws InterruptedException {
        Thread.sleep(500);
        boxes.add(box);
        System.out.println("DOCK " + dockN + "   ADDED BOX: " + box.getBoxN() + " SHIP: " + box.getShipID());
    }

    @Override
    public String toString() {
        return "TASK_01.Dock " + dockN + "\nboxes = " + boxes;
    }
}
