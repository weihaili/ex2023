package com.io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 11:51
 */
public class ClientReadHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    private CountDownLatch counter;

    public ClientReadHandler(AsynchronousSocketChannel channel, CountDownLatch counter) {
        this.channel = channel;
        this.counter = counter;
    }

    public AsynchronousSocketChannel getChannel() {
        return channel;
    }

    public CountDownLatch getCounter() {
        return counter;
    }

    @Override
    public void completed(Integer result, ByteBuffer byteBuffer) {
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);

        String msg = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("client receive : " + msg);
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        System.out.println("data read fail");
        try {
            this.channel.close();
            this.counter.countDown();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
