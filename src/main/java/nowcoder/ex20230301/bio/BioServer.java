package nowcoder.ex20230301.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 11:06
 */
public class BioServer {

    public static void main(String[] args) {
        BioServer demo = new BioServer();
        demo.start();
    }

    private void start() {
        int port = 8888;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ServerHandle(socket)).start();
            }
        } catch (IOException e) {
            System.err.println("BioServer start ioe :" + e.getMessage());
        }
    }

}

class ServerHandle implements Runnable {

    private Socket socket;

    public ServerHandle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                String serMsg = sc.nextLine();
                if ("0".equals(serMsg)) {
                    break;
                }
                String serRecMsg = in.readLine();
                System.out.println("serRecMsg : " + serRecMsg);

                System.out.println("serMsg: " + serMsg);
                out.write(serMsg);
            }
        } catch (IOException e) {
            System.err.println("ServerHandle run ioe :" + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.err.println("ServerHandle close io ioe :" + e.getMessage());
            }
        }
    }
}
