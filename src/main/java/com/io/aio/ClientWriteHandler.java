package com.io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 11:56
 */
public class ClientWriteHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;

    private CountDownLatch counter;

    public ClientWriteHandler(AsynchronousSocketChannel channel, CountDownLatch counter) {
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
    public void completed(Integer result, ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            channel.write(buffer, buffer, this);
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer, byteBuffer, new ClientReadHandler(channel, counter));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
            this.counter.countDown();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
