package TASK_01;

/**
 * Created by Роман on 02.11.2017.
 */
public class Box {
    private int shipID;
    private int boxN;

    public Box(int shipID, int boxN) {
        this.shipID = shipID;
        this.boxN = boxN;
    }

    public int getShipID() {
        return shipID;
    }

    public int getBoxN() {
        return boxN;
    }

    @Override
    public String toString() {
        return "TASK_01.Box{" + "shipID='" + shipID + '\'' + ", boxN='" + boxN + '\'' + '}';
    }
}