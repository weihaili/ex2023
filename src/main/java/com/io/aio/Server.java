package com.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 11:08
 */
public class Server {

    private int port = 8003;

    public static void main(String[] args) {
        AsyncServerHandler serverHandler = new AsyncServerHandler(8083);
        new Thread(serverHandler).start();
    }
}

class AsyncServerHandler implements Runnable {

    private CountDownLatch countDownLatch;

    private AsynchronousServerSocketChannel serverChannel;

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public AsynchronousServerSocketChannel getServerChannel() {
        return serverChannel;
    }

    public AsyncServerHandler(int port) {
        try {
            serverChannel = AsynchronousServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(port));
            System.out.println("server is started");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        countDownLatch = new CountDownLatch(1);
        serverChannel.accept(this, new AcceptHandler());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
