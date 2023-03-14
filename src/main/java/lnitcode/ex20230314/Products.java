package lnitcode.ex20230314;

import java.util.Map;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 15:48
 */
public class Products {
    Map<String, Integer> storage;
    Map<String, Integer> sale;

    // write your code here

    public Products(Map<String, Integer> storage, Map<String, Integer> sale) {
        this.storage = storage;
        this.sale = sale;
    }

    public boolean onSale(String key, int n) {
        return false;
    }

    public int sellOut(String key, int n) {
        return 0;
    }

    public String readStorage() {
        return "";
    }
    public String readSale() {
        return "";
    }
}
