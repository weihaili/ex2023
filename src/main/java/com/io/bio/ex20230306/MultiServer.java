package com.io.bio.ex20230306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 10:32
 */
public class MultiServer {

    public static void main(String[] args) {
        System.out.println("server start...");
        try {
            ServerSocket serverSocket = new ServerSocket(9966);
            List<Socket> sockets = new ArrayList<>();
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getLocalSocketAddress() + " come online");
                sockets.add(socket);
                new Thread(new ServerThread(sockets)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class ServerThread implements Runnable{
    
    private List<Socket> sockets;

    public ServerThread(List<Socket> sockets) {
        this.sockets = sockets;
    }


    @Override
    public void run() {
        if (!sockets.isEmpty()) {
            for (Socket socket : sockets) {
                try {
                    InputStream is = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                    String str = null;
                    while ((str = reader.readLine()) != null) {
                        System.out.println(socket.getRemoteSocketAddress() + " say: " + str);
                        sendMsg(socket, str);
                    }
                } catch (IOException e) {
                    System.out.println(socket.getRemoteSocketAddress() + "offline");
                    sockets.remove(socket);
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void sendMsg(Socket socket, String str) throws IOException {
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println(str);
        ps.flush();
    }
}
