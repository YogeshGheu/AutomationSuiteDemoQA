package pages.subPages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.elements.childPages.CheckBoxPage;
import pages.subPages.elements.childPages.RadioButtonPage;
import pages.subPages.elements.childPages.TextBoxPage;

public class ElementsPage extends BasePage {

    private final By textBoxLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Text Box\"]");
    private final By checkBoxLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Check Box\"]");
    private final By radioButtonLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Radio Button\"]");

    public ElementsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public TextBoxPage clickTextBoxLabelFromDropdown(){
        click(textBoxLabelFromDropdown);
        return new TextBoxPage(driver);
    }

    public CheckBoxPage clickCheckBoxLabelFromDropdown(){
        click(checkBoxLabelFromDropdown);
        return new CheckBoxPage(driver);
    }

    public RadioButtonPage clickRadioButtonLabelFromDropdown(){
        click(radioButtonLabelFromDropdown);
        return new RadioButtonPage(driver);
    }
}
