package leetcdoe.ex202302010.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 9:15
 */
public class CacheDemo {

    private Map<String, String> cacheMap = new HashMap<>();

    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    /**
     * read cache
     *
     * @param key
     * @return cache value
     */
    public String getData(String key) {
        String value = null;
        // get read lock
        rw.readLock().lock();
        try {
            value = cacheMap.get(key);
            if (value != null) {
                return value;
            }
        } finally {
            // release lock
            rw.readLock().unlock();
        }
        // cache key not hit
        rw.writeLock().lock();
        try {
            value = cacheMap.get(key);
            if (value != null) {
                return value;
            }
            value = "query in db";
            cacheMap.put(key, value);
        } finally {
            rw.writeLock().unlock();
        }
        return value;
    }

    public void updateData(String key, String value) {
        // write lock
        rw.writeLock().lock();
        try {
            value = "key mapping value update in db";
            cacheMap.remove(key);
        } finally {
            rw.writeLock().unlock();
        }
    }
}
