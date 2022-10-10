package Gun04;

import Utils.BaseStaticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindingByLinkTest extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.hepsiburada.com/");

        WebElement element = driver.findElement(By.linkText("Siparişlerim"));//Sadece a taglerinde calisir
        System.out.println("element.getText() = " + element.getText());

        System.out.println("element.getAttribute() = " + element.getAttribute("title"));
        System.out.println("element.getAttribute() = " + element.getAttribute("rel"));
        System.out.println("element.getAttribute() = " + element.getAttribute("href"));

        WebElement element2 = driver.findElement(By.partialLinkText("Süper Fiyat"));
        System.out.println("element2.getText() = " + element2.getText()); //Sadece a taglerinde calisir

        bekleKapat();
    }
}
