package lnitcode.ex20230328;

public class ValidWordAbbreviation {

    public static void main(String[] args) {
        ValidWordAbbreviation demo = new ValidWordAbbreviation();
        String word1 = "internationalization", abbr1 = "i12iz4n";
        String word2 = "apple", abbr2 = "a2e";
        String word3 = "aa", abbr3 = "a2";
        String word4 = "aa", abbr4 = "2";
        boolean flag = demo.validWordAbbreviation(word1, abbr1);
        System.out.println(flag);
    }

    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null || word.length() < abbr.length()) {
            return false;
        }
        int len = word.length();
        int aLen = abbr.length();

        int wIdx = 0;
        int aIdx = 0;
        StringBuilder numBuf = new StringBuilder();
        while (wIdx < len || aIdx < abbr.length()) {
            char ac = aIdx >= aLen ? ' ' : abbr.charAt(aIdx);
            if (Character.isDigit(ac)) {
                numBuf.append(ac);
                ++aIdx;
                continue;
            }
            if (numBuf.length() > 0) {
                int num = Integer.parseInt(numBuf.toString());
                wIdx = wIdx + num;
                if (wIdx > len) {
                    return false;
                }
                numBuf.delete(0, numBuf.length());
            }
            char c = wIdx >= len ? ' ' : word.charAt(wIdx);
            if (c != ac) {
                return false;
            }
            ++wIdx;
            ++aIdx;
        }
        return true;
    }


}
