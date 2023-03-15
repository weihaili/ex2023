package lnitcode.ex20230315;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 11:50
 */
public class IThread extends Thread{

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {

            }
        };
    }

    @Override
    public void run() {
        super.run();
        try {
            new Thread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (this.isInterrupted()) {
            System.out.println("Is interrupted");
        } else {
            System.out.println("Not interruputed");
        }
        int priority = 0;
        if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
            System.out.print("Illegal priority");
            return;
        }
        Thread.currentThread().setPriority(priority);
        setPriority(priority);


    }
}
