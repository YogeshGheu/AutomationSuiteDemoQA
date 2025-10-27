package pages.subPages.elements.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import utilities.ActionsUtility;

public class ButtonsPage extends BasePage {
    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By doubleClickMessage = By.id("doubleClickMessage");

    private final By rightClickButton = By.id("rightClickBtn");
    private final By rightClickMessage = By.id("rightClickMessage");

    private final By dynamicClickButton = By.xpath("//button[text()=\"Click Me\"]");
    private final By dynamicClickMessage = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void clickDoubleClickButton() {
        WebElement doubleClickButtonElement = find(doubleClickButton);
        ActionsUtility.doubleClick(doubleClickButtonElement);
    }

    public boolean isDoubleClickMessageVisible() {
        return find(doubleClickMessage).isDisplayed();
    }

    public void clickRightClickButton() {
        WebElement rightClickButtonElement = find(rightClickButton);
        ActionsUtility.rightClick(rightClickButtonElement);
    }

    public boolean isRightClickMessageVisible() {
        return find(rightClickMessage).isDisplayed();
    }

    public void clickDynamicClickButton() {
        click(dynamicClickButton);
    }

    public boolean isDynamicClickMessageVisible() {
        return find(dynamicClickMessage).isDisplayed();
    }

}
