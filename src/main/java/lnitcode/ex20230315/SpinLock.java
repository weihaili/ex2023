package lnitcode.ex20230315;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/15 14:33
 */
public class SpinLock {

    private final AtomicReference<Thread> owner;

    private final AtomicInteger count = new AtomicInteger();

    public SpinLock() {
        // --- write your code here ---
        owner = new AtomicReference();
    }

    public void lock() {
        // --- write your code here ---

    }

    public void unlock() {
        // --- write your code here ---

    }
}
