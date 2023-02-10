package leetcdoe.ex202302010.readwritelock;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/10 15:35
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        PeakIndexInMountainArray demo = new PeakIndexInMountainArray();
        int[] arr = {3, 4, 5, 1};
        int idx = demo.peakIndexInMountainArray(arr);
        System.out.println(idx);
    }

    public int peakIndexInMountainArray1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        int idxS = 1;
        int idxE = len - 2;
        int res = 0;
        while (idxS <= idxE) {
            int idxM = (idxE + idxS) >> 1;
            if (arr[idxM] > arr[idxM + 1]) {
                res = idxM;
                idxE = idxM - 1;
            } else {
                idxS = idxM + 1;
            }
        }
        return res;
    }


    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
