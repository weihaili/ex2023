package leetcdoe.leetcode;

public class SearchFirstWrongVersion {

    public static boolean isBadVersion(int n) {
        return false;
    }

    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        while (first < last) {
            int mid = first + ((last - first) >> 1);
            if (isBadVersion(mid)) {
                last = mid;
            } else {
                first = mid + 1;
            }
        }
        return first;
    }


}
