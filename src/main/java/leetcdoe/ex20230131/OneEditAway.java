package leetcdoe.ex20230131;

public class OneEditAway {

    public static void main(String[] args) {
        OneEditAway demo = new OneEditAway();
        String first = "ab";
        String second = "a12";
        boolean flag = demo.oneEditAway(first, second);
        System.out.println(flag);
    }

    public boolean oneEditAway(String first, String second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null && second != null && second.length() <= 1) {
            return true;
        }
        if (first != null && first.length() <= 1 && second == null) {
            return true;
        }
        int fLen = first.length();
        int sLen = second.length();
        if (Math.abs(fLen - sLen) == 1) {
            return this.oneSave(fLen > sLen ? first : second, fLen > sLen ? second : first);
        } else if (fLen == sLen) {
            boolean difFlag = false;
            for (int i = 0; i < fLen; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (!difFlag) {
                        difFlag = true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean oneSave(String longStr, String shortStr) {
        int lLen = longStr.length();
        int sLen = shortStr.length();
        int lIdx = 0;
        int sIdx = 0;
        while (lIdx < lLen && sIdx < sLen) {
            if (shortStr.charAt(sIdx) == longStr.charAt(lIdx)) {
                sIdx++;
            }
            lIdx++;
            if (lIdx - sIdx > 1) {
                return false;
            }
        }
        return true;
    }
}
