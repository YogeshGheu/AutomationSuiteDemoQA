package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.elements.ElementsPage;
import pages.subPages.forms.FormsPage;
import pages.subPages.forms.childPages.PracticeFormPage;

public class Homepage extends BasePage {

    private final By elementsTile = By.xpath("//div/descendant::h5[text()=\"Elements\"]");
    private final By formsTile = By.xpath("//div/descendant::h5[text()=\"Forms\"]");

    public Homepage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public ElementsPage clickElementsTile(){
        click(elementsTile);
        return new ElementsPage(driver);
    }

    public FormsPage clickFormsTile(){
        click(formsTile);
        return new FormsPage(driver);
    }





}
