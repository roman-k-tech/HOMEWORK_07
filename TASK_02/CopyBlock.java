package TASK_02;

import java.io.FileOutputStream;
import java.util.concurrent.Callable;

/**
 * Created by Роман on 02.11.2017.
 */
public class CopyBlock implements Callable<Boolean> {
    FileOutputStream fos;
    byte[] buffer;
    int byteread;

    public CopyBlock(byte[] buffer, int byteread, FileOutputStream fos) {
        this.fos = fos;
        this.buffer = buffer;
        this.byteread = byteread;
    }

    @Override
    public Boolean call() throws Exception {
        fos.write(buffer, 0, byteread);
        return true;
    }
}
