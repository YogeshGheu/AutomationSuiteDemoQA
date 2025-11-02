package pages.subPages.elements.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class DynamicPropertiesPage extends BasePage {
    private final By enableAfterFiveSecondsButton = By.id("enableAfter");
    private final By colorChangeButton = By.id("colorChange");
    private final By visibleAfterFiveSecondsButton = By.id("visibleAfter");
    private final By randomIdText = By.xpath("//h1[text()=\"Dynamic Properties\"]/following-sibling::p");

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFiveSecondsButtonEnabled() {
        return find(enableAfterFiveSecondsButton).isEnabled();
    }

    public String getColorChangeButtonClass() {
        return find(colorChangeButton).getAttribute("class");
    }

    public boolean isFiveSecondsButtonVisible() {
        try{
            return driver.findElement(visibleAfterFiveSecondsButton).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }

    }

    public String getRandomIdOfText() {
        return find(randomIdText).getAttribute("id");
    }

}
