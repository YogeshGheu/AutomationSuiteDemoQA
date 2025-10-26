package pages.subPages.elements.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

public class RadioButtonPage extends BasePage {

    // radio buttons
//    private final By yesRadio = By.xpath("//label[@for=\"yesRadio\"]");
    private final By yesRadio = By.id("yesRadio");
//    private final By impressiveRadio = By.xpath("//label[@for=\"impressiveRadio\"]");
    private final By impressiveRadio = By.id("impressiveRadio");
    private final By noRadio = By.id("noRadio");

    // message
    private final By outputText = By.xpath("//p[text()=\"You have selected \"]/child::span");

    // constructor
    public RadioButtonPage(WebDriver driver){
        super(driver);
    }

    // methods
    public boolean clickYesRadio(){
        click(yesRadio);
        return find(yesRadio).isSelected();
    }

    public boolean clickImpressiveRadio(){
        click(impressiveRadio);
        return find(impressiveRadio).isSelected();
    }

    public String getOutputText(){
        return find(outputText).getText();
    }

    public boolean isNoRadioClickable(){
        return find(noRadio).isEnabled();
    }

}
