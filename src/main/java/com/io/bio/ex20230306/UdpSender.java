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
public class UdpSender {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8888);
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String data = reader.readLine();
                byte[] datas = data.getBytes(StandardCharsets.UTF_8);
                DatagramPacket packet = new DatagramPacket(
                        datas, 0, datas.length, new InetSocketAddress("127.0.0.1", 8888));
                socket.send(packet);
                if ("bye".equalsIgnoreCase(data)) {
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
