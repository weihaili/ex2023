package lnitcode.ex20230316;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 18:04
 */
public class FindHer {

    public static void main(String[] args) {
        FindHer demo = new FindHer();
        boolean flag = demo.findHer(new String[]{"S..*", "*.**", "...T"});
        System.out.println(flag);
    }

    public boolean findHer(String[] maze) {
        if (maze == null || maze.length == 0) {
            return false;
        }
        char[] chars = maze[0].toCharArray();
        int len = chars.length;
        for (int i = 1; i < maze.length; ++i) {
            char[] temp = maze[i].toCharArray();
            for (int j = 0; j < len; ++j) {

            }
        }
        return len == 0;
    }
}
