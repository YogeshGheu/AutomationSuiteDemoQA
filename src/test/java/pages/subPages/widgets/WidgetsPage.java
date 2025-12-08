package pages.subPages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.widgets.childPages.ToolTipsPage;

public class WidgetsPage extends BasePage {

    private final By toolTipsMenuItem = By.xpath("//span[text()=\"Tool Tips\"]");

    public WidgetsPage(WebDriver driver){
        super(driver);
    }

    public ToolTipsPage clickToolTipsMenuItem(){
        click(toolTipsMenuItem);
        return new ToolTipsPage(driver);
    }




}
