package pages.subPages.AFW.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class AlertsPage extends BasePage {

    private final By clickAlertButton = By.id("alertButton");
    private final By timerAlertButton = By.id("timerAlertButton");
    private final By confirmAlertButton = By.id("confirmButton");
    private final By confirmResultText = By.id("confirmResult");
    private final By promptAlertButton = By.id("promtButton");
    private final By promptResultText = By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void generateClickAlert() {
        click(clickAlertButton);
    }

    public void generateAlertAfterFiveSeconds() {
        click(timerAlertButton);
    }

    public void generateConfirmAlert() {
        click(confirmAlertButton);
    }

    public String getConfirmAlertResult(){
        return find(confirmResultText).getText();
    }

    public void generatePromptAlert() {
        click(promptAlertButton);
    }

    public String getPromptAlertResult(){
        return find(promptResultText).getText();
    }


}
