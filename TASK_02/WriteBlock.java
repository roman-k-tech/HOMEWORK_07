package TASK_02;

import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/**
 * Created by Роман on 02.11.2017.
 */
public class WriteBlock implements Callable<Boolean> {
    private byte[] buffer;
    private int byteread;
    private FileOutputStream fOS;
    private ActionSwitch actionSwitch;

    public WriteBlock(FileOutputStream fOS, ActionSwitch actionSwitch) {
        this.fOS = fOS;
        this.actionSwitch = actionSwitch;
    }

    @Override
    public Boolean call() throws Exception {

        int i = 0;
        do {
            this.buffer = actionSwitch.getbuffer();
            this.byteread = actionSwitch.getbyteread();
            fOS.write(buffer, 0, byteread);
            System.out.println(++i + "K copied");
        }
        while (actionSwitch.isStop() == false);

        return true;
    }
}
