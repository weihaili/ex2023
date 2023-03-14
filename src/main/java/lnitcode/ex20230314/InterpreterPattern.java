package lnitcode.ex20230314;

/**
 * Description:
 *
 * @author Admin
 * @date 2023/3/14 17:03
 */
public class InterpreterPattern {

    private String[] citys = {"杭州", "绍兴"};
    private String[] local = {"老人", "学生"};
    private String[] card = {"市民卡", "交通卡"};
    private String[] global = {"孕妇", "儿童", "残疾人", "军人"};
    private String s1 = "本次乘车免费~";
    private String s2 = "请付费！";
    private Expression free;

    public String freeRide(String passenger) {
        return free.interpret(passenger)? s1: s2;
    }

    public InterpreterPattern () {
        free = new OrExpression(new TerminalExpression(global),
                new AndExpression(new TerminalExpression(citys),
                        new AndExpression(new TerminalExpression(local), new TerminalExpression(card))));
    }
}
