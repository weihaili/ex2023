package leetcdoe.ex20230207;

import java.applet.Applet;
import java.awt.*;

/**
 * Description:
 * 1. use appletviewer MyApplet.java run
 * 2. nesting html,run use browser
 *
 * @author Admin
 * @date 2023/2/7 8:49
 */
public class MyApplet extends Applet {

    public void paint(Graphics g) {
        g.drawString("my name is ", 20, 20);
        g.drawString("li ", 20, 40);
        g.drawString("wei ", 20, 60);
        g.drawString("hai ", 20, 80);
    }
}
