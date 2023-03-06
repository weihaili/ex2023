package com.io.aio;

import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 11:39
 */
public class Client {

    public static void main(String[] args) {
        AsyncClientHandler clientHandler = new AsyncClientHandler("127.0.0.1", 8083);
        new Thread(clientHandler).start();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String msg = sc.nextLine();
            clientHandler.sendMsg(msg);
        }

    }
}

class AsyncClientHandler implements Runnable {

    private String ipStr;

    private int port;

    public AsyncClientHandler(String ipStr, int port) {
        this.ipStr = ipStr;
        this.port = port;
    }

    @Override
    public void run() {

    }

    public void sendMsg(String msg) {
    }
}
