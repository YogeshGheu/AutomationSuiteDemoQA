package pages.subPages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.forms.childPages.PracticeFormPage;

public class FormsPage extends BasePage {

    private final By tileElementPracticeForm = By.xpath("//span[text()=\"Practice Form\"]");

    public FormsPage(WebDriver driver){
        super(driver);
    }

    public PracticeFormPage clickTileElementPracticeForm(){
        click(tileElementPracticeForm);
        return new PracticeFormPage(driver);
    }




}
