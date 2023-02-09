package leetcdoe.ex20230209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/9 11:11
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis demo = new GenerateParenthesis();
        List<String> res = demo.generateParenthesis(3);
        if (res == null) {
            System.out.println("res is null");
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", n, n);
        return res;
    }

    private void generate(List<String> res, String str, int ln, int rn) {
        if (ln == 0 && rn == 0) {
            res.add(str);
            return;
        }
        if (ln == rn) {
            generate(res, str + "(", ln - 1, rn);
        } else if (ln < rn) {
            if (ln > 0) {
                generate(res, str + "(", ln - 1, rn);
            }
            generate(res, str + ")", ln, rn - 1);
        }
    }
}
