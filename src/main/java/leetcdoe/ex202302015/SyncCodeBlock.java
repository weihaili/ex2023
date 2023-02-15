package leetcdoe.ex202302015;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/15 13:26
 */
public class SyncCodeBlock {

    public int i;

    public void syncTask() {
        synchronized (this) {
            ++i;
        }
    }
}
