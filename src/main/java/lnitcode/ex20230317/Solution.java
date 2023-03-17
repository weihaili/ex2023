package lnitcode.ex20230317;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/17 10:04
 */
public class Solution {

    private Solution () {
    }

    private static final Solution instance = new Solution();

    public static Solution getInstance() {
        return instance;
    }
}
