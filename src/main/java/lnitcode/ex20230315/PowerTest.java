package lnitcode.ex20230315;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 11:22
 */
public class PowerTest {

    public static void main(String[] args) {
        PowerTest demo = new PowerTest();
        Future<Long> future = demo.power(10L);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

    public Future<Long> power(long val) {
        CompletableFuture<Long> future = new CompletableFuture();

        System.out.println(future.join());
        return future;
    }
}
