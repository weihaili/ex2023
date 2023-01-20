package ioex.test20230118;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class LoopDirFile {

    public static void main(String[] args) {
        LoopDirFile demo = new LoopDirFile();
        File file = demo.createFile();

        //System.out.println(demo.isFile(file));

        String path = "D:\\B-50424\\code-rep\\iotest\\test" + System.currentTimeMillis();
        demo.createDirectory(path);

        // move file

        FileInputStream inputStream;

        FileOutputStream outputStream;

        LockSupport.park();;

        Thread thread ;

        Executors executors;

        Executors.newFixedThreadPool(4);

        Class clz;






        Class<String> stringClass = String.class;
    }

    private void createDirectory(String path) {
        File file = new File(path);
        boolean createDirFlag = file.mkdir();
        System.out.println(createDirFlag ? "create directory success" : "create directory fail");
    }


    public boolean isFile(File file) {
        return file.isFile();
    }

    private File createFile() {
        File file = new File("D:\\B-50424\\code-rep\\iotest", System.currentTimeMillis()+".txt");

        try {
            boolean isCreate = file.createNewFile();
            if (isCreate) {
                System.out.println("create file success");
            } else {
                System.out.println("create file fail,file already exist.");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return file;
    }

    private void searchFile() {

    }
}
