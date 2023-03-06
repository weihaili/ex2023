package com.io.bio.ex20230306;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 8:40
 */
public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            serverSocket = new ServerSocket(9921);
            while (true) {
                socket = serverSocket.accept();
                is = socket.getInputStream();

                baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];

                int len = 0;
                while ((len = is.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                System.out.println("server received msg："+ baos.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
