package nowcoder.ex20230227;

public enum SingletonEnum {

    SINGLETON_ENUM_10(10);

    private int count;

    SingletonEnum(int count) {
        this.count = count;
    }

    public void test() {
        ++count;
    }

    public int getCount() {
        return count;
    }
}
