package leetcdoe.ex20230206;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/6 10:57
 */
public class NioDemo {

    public static void main(String[] args) {
        NioDemo demo = new NioDemo();
        demo.testNioServer();
        demo.testNioClient();

        demo.testOrgIo();
    }

    private void testOrgIo() {
    }

    private void testNioClient() {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("", 3306));
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_READ);

            FileChannel fileChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (fileChannel.read(buf) != -1) {
                buf.flip();
                socketChannel.write(buf);
                buf.clear();
            }

            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectedKey = iterator.next();
                    while (selectedKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectedKey.channel();
                        ByteBuffer respBuf = ByteBuffer.allocate(1024);
                        int readBytes = channel.read(respBuf);
                        if (readBytes > 0) {
                            respBuf.flip();
                            System.out.println(new String(respBuf.array(), 0, readBytes));
                        }
                    }
                }
                iterator.remove();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void testNioServer() {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.configureBlocking(false);
            serverChannel.bind(new InetSocketAddress(3306));

            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (selector.select() > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();

                    if (selectionKey.isAcceptable()) {
                        SocketChannel clientSocket = serverChannel.accept();
                        clientSocket.configureBlocking(false);
                        clientSocket.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel readSocketChannel = (SocketChannel) selectionKey.channel();

                        ByteBuffer buf = ByteBuffer.allocate(1024);

                        FileChannel outFileChannel = FileChannel.open(Paths.get(""), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

                        while (readSocketChannel.read(buf) > 0) {
                            buf.flip();
                            outFileChannel.write(buf);
                            buf.clear();
                        }
                    }
                    iterator.remove();
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
