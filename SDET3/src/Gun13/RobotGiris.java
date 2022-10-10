package Gun13;

import Utils.BaseStaticDriver;
import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotGiris extends BaseStaticDriver {

    public static void main(String[] args) throws AWTException {
        driver.get("https://demo.guru99.com/test/upload/");

        Robot rbt = new Robot();

        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);
        bekle(2);

        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);
        bekle(2);

        bekleKapat();
    }
}
