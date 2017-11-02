package TASK_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Роман on 02.11.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String fileName = "123.txt";
        String outFileName = "copy_" + fileName;

        File inputFile = new File(fileName);

        if (inputFile.exists()) {
            File copiedFile = new File(outFileName);

            ArrayList<Future<Boolean>> copyBlocks = new ArrayList<>();
            ExecutorService executorService = Executors.newFixedThreadPool(3);

            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(copiedFile);

            byte[] buffer = new byte[1024];
            int byteread = 0;
            while ((byteread = fis.read(buffer)) > 0) {
                copyBlocks.add(executorService.submit(new CopyBlock(buffer, byteread, fos)));
            }

            int count = 0;
            System.out.println("0 KB copied");
            for (Future<Boolean> block : copyBlocks) {
                if (block.get()) {
                    count++;
                    System.out.println(count + " KB copied");
                }
            }

            executorService.shutdown();
        } else {
            System.out.println("ERROR!");
        }
    }
}



























