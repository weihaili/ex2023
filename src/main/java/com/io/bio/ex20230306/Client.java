package com.io.bio.ex20230306;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 8:40
 */
public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("I am client I want send server msg");
        while (true) {
            Socket socket = null;
            OutputStream os = null;
            String msg = sc.nextLine();

            try {
                InetAddress serverIp = InetAddress.getByName("127.0.0.1");
                int port = 9921;

                socket = new Socket(serverIp, port);
                os = socket.getOutputStream();

                os.write(msg.getBytes());
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
