package pages.subPages.AFW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.AFW.childPages.AlertsPage;

public class AlertsFrameWindowsPage extends BasePage {

    private static final By menuItemAlerts = By.xpath("//span[text()=\"Alerts\"]");


    public AlertsFrameWindowsPage(WebDriver driver){
        super(driver);
    }

    public AlertsPage clickMenuItemAlerts(){
        click(menuItemAlerts);
        return new AlertsPage(driver);
    }




}
