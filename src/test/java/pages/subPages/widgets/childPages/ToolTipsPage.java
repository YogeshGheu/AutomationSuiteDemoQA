package pages.subPages.widgets.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import utilities.ActionsUtility;
import utilities.JavaScriptUtility;

public class ToolTipsPage extends BasePage {

    // locators
    private final By toolTipsPageHeading = By.xpath("//h1[text()=\"Tool Tips\"]");

    private final By hoverMeButton = By.id("toolTipButton");
    private final By buttonToolTip = By.id("buttonToolTip");

    private final By textField = By.id("toolTipTextField");
    private final By textFieldToolTip = By.id("textFieldToolTip");

    //constructor
    public ToolTipsPage(WebDriver driver){
        super(driver);
    }

    public boolean isToolTipsPageHeadingVisible(){
        return find(toolTipsPageHeading).isDisplayed();
    };

    public void hoverOnButton(){
        WebElement button = find(hoverMeButton);
        JavaScriptUtility.jsScroll(button);
        ActionsUtility.moveToElement(button);
    }

    public boolean isButtonToolTipVisible(){
        return find(buttonToolTip).isDisplayed();
    }

    public void hoverOverTextField(){
        WebElement textFieldElement = find(textField);
        JavaScriptUtility.jsScroll(textFieldElement);
        ActionsUtility.moveToElement(textFieldElement);
    }

    public boolean isTextFieldToolTipVisible(){
        return find(textFieldToolTip).isDisplayed();
    }

}
