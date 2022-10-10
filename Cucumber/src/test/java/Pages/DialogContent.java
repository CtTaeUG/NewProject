package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent{

    public DialogContent(){
        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(id="mat-input-0")
    public WebElement username;

    @FindBy(id="mat-input-1")
    public WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(xpath="(//span[contains(text(),'Dashboard')])[2]")
    public WebElement dashboard;


    WebElement myElement;

    public void findAndSend (String strElement, String value) {

        switch (strElement) {
            case "username" : myElement = username; break;
            case "password" : myElement = password; break;
        }

        /*
        if(strElement == "username")
            myElement = username;
        else
            if (strElement == "password")
                myElement = password;

         */


        sendKeysFunction(myElement, value);
    }

    /*
    public void findAndClick (String strElement) {

        switch (strElement) {
            case "loginButton" : myElement = loginButton; break;
            case "addButton" : myElement = addButton; break;
        }

        clickFunction(myElement);
    }

     */

    public void findAndContainsText (String strElement, String text) {

        switch (strElement) {
            case "dashboard" : myElement = dashboard; break;
        }

        verifyContainsText(myElement, text);
    }

}
