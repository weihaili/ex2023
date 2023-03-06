package com.io.bio.ex20230306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/6 9:49
 */
public class UdpReceiver {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(6668);
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String recMsg = new String(data, 0, data.length);
                if ("bye".equalsIgnoreCase(recMsg)) {
                    break;
                }
            }
            socket.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
