package pages.subPages.elements.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;

public class CheckBoxPage extends BasePage {
    private final By homeCheckBox = By.xpath("//input[@id=\"tree-node-home\"]/following-sibling::span[@class='rct-checkbox']");
    private final List<WebElement> allResultElements = findAll(By.xpath("//span[@class=\"text-success\"]"));
    public CheckBoxPage(WebDriver driver){
        super(driver);
    }

    public void clickOnHomeCheckBox(){
        click(homeCheckBox);
    }
    public int allResultsCount(){
        return allResultElements.size();
    }

}
