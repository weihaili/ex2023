package com.io.bio.ex20230306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 10:32
 */
public class MultiClient {

    public static void main(String[] args) {
        System.out.println("client start.....");
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9966);
            new Thread(new ClientThread(socket)).start();

            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("please import: ");
                String msg = sc.nextLine();
                ps.println(msg);
                ps.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ClientThread implements Runnable{

    private Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while (true) {
                if ((str = reader.readLine()) != null) {
                    System.out.println("received : " + str);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
