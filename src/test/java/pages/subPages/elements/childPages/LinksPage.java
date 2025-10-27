package pages.subPages.elements.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utilities.WaitUtility;

public class LinksPage extends BasePage {

    private final By createdLink = By.id("created");
    private final By noContent = By.id("no-content");
    private final By movedLink = By.id("moved");
    private final By badRequestLink = By.id("bad-request");
    private final By unauthorizedLink = By.id("unauthorized");
    private final By forbiddenLink = By.id("forbidden");
    private final By notFoundLink = By.id("invalid-url");

    private final By statusCodeLocator = By.xpath("//p[@id=\"linkResponse\"]/child::b[1]");
    private final By statusTextLocator = By.xpath("//p[@id=\"linkResponse\"]/child::b[2]");

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreatedLink() {
        click(createdLink);
    }

    public void clickNoContentLink() {
        click(noContent);
    }

    public void clickMovedLink() {
        click(movedLink);
    }

    public void clickBadRequestLink() {
        click(badRequestLink);
    }

    public void clickUnauthorizedLink() {
        click(unauthorizedLink);
    }

    public void clickForbiddenLink() {
        click(forbiddenLink);
    }

    public void clickNotFoundLink() {
        click(notFoundLink);
    }

    public String[] getResponse(String statusCode, String statusText) {
        WaitUtility.waitForTextToBe(statusCodeLocator, statusCode);
        WaitUtility.waitForTextToBe(statusTextLocator, statusText);
        return new String[]{find(statusCodeLocator).getText(), find(statusTextLocator).getText()};
    }

}
