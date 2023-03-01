package nowcoder.ex20230301.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 11:54
 */
public class NioServer {

    public static void main(String[] args) {
        NioServer demo = new NioServer();
        demo.start();
    }

    private void start() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel server = ServerSocketChannel.open();
            server.socket().bind(new InetSocketAddress(8888));

            server.configureBlocking(false);
            server.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                int readyChannels = selector.select();
                if (readyChannels == 0) {
                    continue;
                }
                Set<SelectionKey> readyKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = readyKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        SocketChannel socketChannel = server.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel socketChannel =(SocketChannel) key.channel();
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int num = socketChannel.read(readBuffer);
                        if (num > 0) {
                            String recMsg = new String(readBuffer.array());
                            System.out.println("server received msg: " + recMsg);
                            String serRespMsg = "NIO server received .";
                            ByteBuffer respBuf = ByteBuffer.wrap(serRespMsg.getBytes());
                            socketChannel.write(respBuf);
                        } else if (num == -1){
                            socketChannel.close();
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("NioServer start ioe :" + e.getMessage());
        }
    }
}
