package lnitcode.ex20230327;

public class HashCodeTest {

    public static void main(String[] args) {
        HashCodeTest demo = new HashCodeTest();
        int val = demo.hashCode("ubantu", 1007);
        System.out.println(val);

    }

    public int hashCode(String key, int hASH_SIZE) {
        if (key == null || key.length() == 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            sum = (sum * 33 + c) % hASH_SIZE;
        }
        return (int)sum;
    }

    public int hashCode1(String key, int hASH_SIZE) {
        if (key == null || key.length() == 0) {
            return 0;
        }
        int len = key.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (int)key.charAt(i) * Math.pow(33, len - 1 - i);
        }

        return sum % hASH_SIZE;
    }
}
