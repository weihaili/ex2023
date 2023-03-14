package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 17:05
 */
public class TerminalExpression implements Expression {

    private String[] data;

    public TerminalExpression(String[] data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        for (String str : data) {
            if (context.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
