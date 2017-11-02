package TASK_01;

/**
 * Created by Роман on 02.11.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dock dock1 = new Dock("1");
        Dock dock2 = new Dock("2");

        Ship ship1 = new Ship(1, dock1, dock2);
        Ship ship2 = new Ship(2, dock1, dock2);
        Ship ship3 = new Ship(3, dock1, dock2);

        Thread shipThread1 = new Thread(ship1);
        Thread shipThread2 = new Thread(ship2);
        Thread shipThread3 = new Thread(ship3);

        shipThread1.start();
        shipThread2.start();
        shipThread3.start();

//        shipThread1.join();
//        shipThread2.join();
//        shipThread3.join();
//
//        System.out.println(dock1.toString());
//        System.out.println(dock2.toString());

    }
}
