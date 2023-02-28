package nowcoder.ex20230228;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/28 18:38
 */
public class Find {

    public static void main(String[] args) {
        Find demo = new Find();
        boolean flag = demo.Find(16, new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}});
        System.out.println(flag);
    }

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length;
        int columns = array[0].length;
        for (int i = 0; i < array.length; ++i) {
            if (array[i][columns - 1] < target) {
                continue;
            }
            if (array[i][0] > target) {
                break;
            }
            int lidx = 0;
            int ridx = columns - 1;
            while (lidx <= ridx) {
                int midx = lidx + ridx >> 1;
                int midval = array[i][midx];
                if (midval == target) {
                    return true;
                } else if (midval > target) {
                    ridx = midx - 1;
                } else {
                    lidx = midx + 1;
                }
            }
        }
        return false;
    }
}
