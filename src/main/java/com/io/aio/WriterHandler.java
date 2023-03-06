package com.io.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 11:35
 */
public class WriterHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public WriterHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if (buffer.hasRemaining()) {
            channel.write(buffer, buffer, this);
        } else {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer, byteBuffer, new ReaderHandler(channel));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
