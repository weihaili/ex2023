package com.io.bio.ex20230306;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 9:30
 */
public class FileUploadClient {

    public static void main(String[] args) {
        Socket socket = null;
        FileInputStream fis = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            fis = new FileInputStream("D:\\B-50424\\temp\\org\\test1.txt");
            socket = new Socket("127.0.0.1", 8687);
            os = socket.getOutputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            socket.shutdownOutput();
            is = socket.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            System.out.println(bos.toString());
            fis.close();
            socket.close();
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
