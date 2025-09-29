package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.elements.ElementsPage;

public class Homepage extends BasePage {

    public Homepage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private final By elementsTile = By.xpath("//div/descendant::h5[text()=\"Elements\"]");

    public ElementsPage clickElementsTile(){
        return new ElementsPage(driver);
    }







}
