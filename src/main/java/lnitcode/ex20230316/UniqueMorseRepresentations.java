package lnitcode.ex20230316;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/16 10:49
 */
public class UniqueMorseRepresentations {

    public static void main(String[] args) {
        UniqueMorseRepresentations demo = new UniqueMorseRepresentations();
        int num = demo.uniqueMorseRepresentations(new String[]{"a", "b"});
        System.out.println(num);
    }

    private String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--",
            "-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        int cnt = 0;
        if (words == null || words.length == 0) {
            return cnt;
        }
        Set<String> dic = new HashSet<String>();
        StringBuilder buf = new StringBuilder();
        for (String word : words) {
            if (word == null) {
                continue;
            }
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if (Character.isLetter(c)) {
                    buf.append(morse[c - 'a']);
                }
            }
            dic.add(buf.toString());
            buf.delete(0, buf.length());
        }
        return dic.size();
    }
}
