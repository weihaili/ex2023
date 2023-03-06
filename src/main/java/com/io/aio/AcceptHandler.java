package com.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 11:19
 */
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncServerHandler> {
    @Override
    public void completed(AsynchronousSocketChannel channel, AsyncServerHandler serverHandler) {
        serverHandler.getServerChannel().accept(serverHandler, this);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        channel.read(buf, buf, new ReaderHandler(channel));
    }

    @Override
    public void failed(Throwable exc, AsyncServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.getCountDownLatch().countDown();
    }
}
