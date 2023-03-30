package lnitcode.ex20230330;

public class JudgmentString {

    public static void main(String[] args) {
        JudgmentString demo = new JudgmentString();

    }

    public boolean judgmentString(String str1,String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str1.equalsIgnoreCase(str2)) {
            return true;
        }
        return false;
    }
}
