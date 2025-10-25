package pages.subPages.AFW.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utilities.SwitchToUtility;
import utilities.WaitUtility;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {

    private final By newTabButton = By.id("tabButton");
    private final By newWindowButton = By.id("windowButton");
    private final By getNewWindowMessageButton = By.id("messageWindowButton");
    private final By textOnNewTab = By.id("sampleHeading");
    private final By textOnNewWindowsMessage = By.xpath("//body[contains(text(), \"Knowledge\")]");
    private final By windowsPageHeading = By.xpath("//h1[text()=\"Browser Windows\"]");

    public final static Map<String, String> windowsIds = new HashMap<>();

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
        String parentWindowHandle = driver.getWindowHandle();
        windowsIds.put("parentWindow", parentWindowHandle);
    }

    private void generateUpdateWindowIdsChild(){
        // currently we are only managing 1 level of child tabs/windows
        Set<String> allWindowHandles = driver.getWindowHandles();
        for(String windowHandle : allWindowHandles){
            if(!windowsIds.containsValue(windowHandle)){
                windowsIds.put("childWindow", windowHandle);
            }
        }
    }

    public void clickNewTabButton(){
        click(newTabButton);
        generateUpdateWindowIdsChild();
        System.out.println(windowsIds);
    }

    public void clickNewWindowButton(){
        click(newWindowButton);
        generateUpdateWindowIdsChild();
        System.out.println(windowsIds);
    }

    public void clickGetNewWindowMessageButton(){
        click(getNewWindowMessageButton);
        generateUpdateWindowIdsChild();
        System.out.println(windowsIds);
    }

    public String getTextOnNewWindow(){
        return find(textOnNewTab).getText();
    }

    // could not find a way to handle it, instead will only check that the new window is opened or not
    public String getTextOnNewWindowsMessage(){
        return find(textOnNewWindowsMessage).getText();
    }

    public boolean isOnMainWindowsPage(){
        return find(windowsPageHeading).isDisplayed();
    }



}
