package leetcdoe.ex202302023;

import org.apache.tomcat.util.digester.ArrayStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/23 17:42
 */
public class FindSubstring {

    public static void main(String[] args) {
        FindSubstring demo = new FindSubstring();
        List<Integer> res = demo.findSubstring("", new String[]{});
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        return new ArrayList<>();
    }
}
