package pages.subPages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.elements.childPages.*;

public class ElementsPage extends BasePage {

    private final By textBoxLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Text Box\"]");
    private final By checkBoxLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Check Box\"]");
    private final By radioButtonLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Radio Button\"]");
    private final By buttonsLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Buttons\"]");
    private final By linksLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Links\"]");
    private final By dynamicPropertiesLabelFromDropdown = By.xpath("//li/descendant::span[text()=\"Dynamic Properties\"]");

    public ElementsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public TextBoxPage clickTextBoxLabelFromDropdown() {
        click(textBoxLabelFromDropdown);
        return new TextBoxPage(driver);
    }

    public CheckBoxPage clickCheckBoxLabelFromDropdown() {
        click(checkBoxLabelFromDropdown);
        return new CheckBoxPage(driver);
    }

    public RadioButtonPage clickRadioButtonLabelFromDropdown() {
        click(radioButtonLabelFromDropdown);
        return new RadioButtonPage(driver);
    }

    public ButtonsPage clickButtonsLabelFromDropdown() {
        click(buttonsLabelFromDropdown);
        return new ButtonsPage(driver);
    }

    public LinksPage clickLinksFromDropdown() {
        click(linksLabelFromDropdown);
        return new LinksPage(driver);
    }

    public DynamicPropertiesPage clickDynamicPropertiesLabelFromDropdown() {
        click(dynamicPropertiesLabelFromDropdown);
        return new DynamicPropertiesPage(driver);
    }
}
