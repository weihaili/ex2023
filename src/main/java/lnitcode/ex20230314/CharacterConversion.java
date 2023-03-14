package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 18:32
 */
public class CharacterConversion {

    public static void main(String[] args) {
        CharacterConversion demo = new CharacterConversion();
        boolean flag = demo.characterConversion("ABC", new int[]{97, 98, 99});
        System.out.println(flag);
    }

    public boolean characterConversion(String str,int arr[]) {
        if (str == null || arr == null) {
            return false;
        }
        int slen = str.length();
        int alen = arr.length;
        if (alen != slen) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if ((int)chars[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
