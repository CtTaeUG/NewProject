package Gun10;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class WaiteGiris extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

//        Duration dr = Duration.ofSeconds(120);
//        driver.manage().timeouts().implicitlyWait(dr);

        WebElement btn = driver.findElement(By.cssSelector("[onclick = 'timeText()']"));
        btn.click();

        WebElement webDriverText = driver.findElement(By.xpath("//p[text() = 'WebDriver']"));

        bekleKapat();
    }
}
