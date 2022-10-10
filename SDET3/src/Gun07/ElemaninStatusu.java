package Gun07;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElemaninStatusu extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        WebElement sali = driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));

        System.out.println(sali.isDisplayed());
        System.out.println(sali.isEnabled());
        System.out.println(sali.isSelected());

        bekle(2);

        sali.click();
        System.out.println(sali.isSelected());

        bekleKapat();
    }
}
