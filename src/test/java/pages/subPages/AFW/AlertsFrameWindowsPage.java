package pages.subPages.AFW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.subPages.AFW.childPages.AlertsPage;
import pages.subPages.AFW.childPages.BrowserWindowsPage;

public class AlertsFrameWindowsPage extends BasePage {

    private static final By menuItemAlerts = By.xpath("//span[text()=\"Alerts\"]");
    private static final By menuItemBrowserWindows = By.xpath("//span[text()=\"Browser Windows\"]");


    public AlertsFrameWindowsPage(WebDriver driver){
        super(driver);
    }

    public AlertsPage clickMenuItemAlerts(){
        click(menuItemAlerts);
        return new AlertsPage(driver);
    }

    public BrowserWindowsPage clickMenuItemBrowserWindows(){
        click(menuItemBrowserWindows);
        return new BrowserWindowsPage(driver);
    }




}
