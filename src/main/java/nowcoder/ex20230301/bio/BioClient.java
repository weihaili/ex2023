package nowcoder.ex20230301.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/1 11:06
 */
public class BioClient {
    public static void main(String[] args) {
        BioClient deno = new BioClient();
        deno.start();
    }

    private void start() {
        int port = 8888;
        String ip = "127.0.0.1";
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            Socket socket = new Socket(ip, port);

            Scanner scn = new Scanner(System.in);
            while (true) {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String msg = scn.nextLine();
                if (msg.equals("0")) {
                    break;
                }
                System.out.println("client write msg: " + msg);
                out.println(msg);

                String s = in.readLine();
                System.out.println("client read msg: " + s);
            }
        } catch (IOException e) {
            System.err.println("BioClient start ioe :" + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                System.err.println("BioClient start close io ioe :" + e.getMessage());
            }
        }
    }
}
