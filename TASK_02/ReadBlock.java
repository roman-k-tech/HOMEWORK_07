package TASK_02;

import java.io.FileInputStream;
import java.util.concurrent.Callable;

/**
 * Created by Роман on 05.11.2017.
 */
public class ReadBlock implements Callable<Boolean> {
    private byte[] buffer;
    private int byteread;
    private FileInputStream fIS;
    private ActionSwitch actionSwitch;

    public ReadBlock(FileInputStream fIS, ActionSwitch actionSwitch) {
        this.fIS = fIS;
        this.actionSwitch = actionSwitch;
    }

    @Override
    public Boolean call() throws Exception {

        byte[] buffer = new byte[1024];
        int byteread = 0;
        actionSwitch.setStop(false);
        while ((byteread = fIS.read(buffer)) > 0) {
            actionSwitch.setInfo(byteread, buffer.clone());
        }

        actionSwitch.setStop(true);
        return true;
    }
}
