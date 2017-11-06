package TASK_02;

/**
 * Created by Роман on 05.11.2017.
 */
public class ActionSwitch {
    private byte[] buffer;
    private int byteread;

    private boolean turn = false;
    private boolean stop = false;

    public synchronized void setInfo(int byteread, byte[] buffer) throws InterruptedException {
        if (turn == true) {
            wait(); }
        this.buffer = buffer;
        this.byteread = byteread;

        turn = true;
        notifyAll();
    }

    public synchronized byte[] getbuffer() throws InterruptedException {
        if (turn == false) {
            wait(); }

        return buffer;
    }

    public synchronized int getbyteread() {
        turn = false;
        notifyAll();

        return byteread;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) throws InterruptedException {
        this.stop = stop;
//        Thread.sleep(100);
        if (this.stop == true) {
            notifyAll();
        }
    }
}
