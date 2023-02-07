package leetcdoe.ex20230207;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/2/7 13:33
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid demo = new IsValid();
        boolean flag = demo.isValid("(){}}{");
        System.out.println(flag);
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        String orgStr = s;
        int len = orgStr.length();
        while (orgStr.length() > 0) {
            String curStr = orgStr.replace("()", "").replace("[]", "").replace("{}", "");
            int temp = curStr.length();
            if (temp == len) {
                break;
            } else {
                len = curStr.length();
                orgStr = curStr;
            }
        }
       return orgStr.length() == 0;
    }
}

