package com.io.bio.ex20230306;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 9:40
 */
public class FileUploadServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8687);
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            File file = new File("D:\\B-50424\\temp\\copy");
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(file + "\\test2.txt");
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            OutputStream os = socket.getOutputStream();
            os.write("upload successfully".getBytes(StandardCharsets.UTF_8));
            fos.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
