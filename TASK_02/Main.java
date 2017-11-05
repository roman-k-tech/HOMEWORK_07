package TASK_02;

import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Роман on 02.11.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String fileName = "123.png";
        String outFileName = "copy_" + fileName;

        File inputFile = new File(fileName);

        if (!inputFile.exists()) {
            System.out.println("ERROR!");
            return;
        }
        File copiedFile = new File(outFileName);

        FileInputStream fIS = new FileInputStream(inputFile);
        FileOutputStream fOS = new FileOutputStream(copiedFile);

        ExecutorService readThread = Executors.newSingleThreadExecutor();
        ExecutorService writeThread = Executors.newSingleThreadExecutor();

        ActionSwitch actionSwitch = new ActionSwitch();
        Future<Boolean> started = readThread.submit(new ReadBlock(fIS, actionSwitch));
        Future<Boolean> finished = writeThread.submit(new WriteBlock(fOS, actionSwitch));

        try {
            if (finished.get(2, TimeUnit.SECONDS)) {
                System.out.println("Copy finished.");
                readThread.shutdown();
                writeThread.shutdown();
            }
        }
        catch (TimeoutException e) {e.printStackTrace();}
        finally {
            readThread.shutdownNow();
            writeThread.shutdownNow();
            fIS.close();
            fOS.close();
            return;
        }
    }
}



























