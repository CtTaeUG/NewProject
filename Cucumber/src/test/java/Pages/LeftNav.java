package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath="(//span[text()='Setuo'])[1]")
    public WebElement setupone;

    @FindBy(xpath="//span[text()='Parameters']")
    public WebElement parameters;

    @FindBy(xpath="//span[text()='Countries']")
    public WebElement Countries;

    WebElement myElement;

    public void findAndClick (String strElement) {

        switch (strElement) {
            case "setupOne":
                myElement = setupone;
                break;
            case "parameters":
                myElement = parameters;
                break;
            case "countries":
                myElement = Countries;
                break;

        }

        clickFunction(myElement);
    }


}
