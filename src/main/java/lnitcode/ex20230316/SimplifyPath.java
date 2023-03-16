package lnitcode.ex20230316;

import java.util.LinkedList;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 14:19
 */
public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath demo = new SimplifyPath();
        String res = demo.simplifyPath("/a/./../../c/");
        System.out.println(res);
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String[] strs = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        for (String str : strs) {
            if ("..".equals(str)) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
            } else if (!".".equals(str) && !"".equals(str)) {
                list.add(str);
            }
        }
        StringBuilder buf = new StringBuilder("/");
        while (!list.isEmpty()) {
            buf.append(list.removeFirst()).append("/");
        }
        return buf.length() > 2 ? buf.substring(0, buf.length() -1) : buf.toString();
    }
}
