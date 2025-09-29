package pages.subPages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.elements.childPages.TextBoxPage;

public class ElementsPage extends BasePage {

    private final By textBoxLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Text Box\"]");

    public ElementsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public TextBoxPage clickTextBoxLabelFromDropdown(){
        click(textBoxLabelFromDropdown);
        return new TextBoxPage(driver);
    }
}
