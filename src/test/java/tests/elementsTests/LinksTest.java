package tests.elementsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.elements.childPages.LinksPage;

public class LinksTest extends BaseTest {
    @Test(description = "test api links and their response")
    public void testLinks() {
        Homepage homepage = new Homepage(getDriver());
        LinksPage linksPage = homepage.clickElementsTile().clickLinksFromDropdown();

        // Test created link and response
        linksPage.clickCreatedLink();
        String[] createdResponse = linksPage.getResponse("201", "Created");
        Assert.assertEquals(createdResponse[0], "201");
        Assert.assertEquals(createdResponse[1], "Created");

        // Test no content link and response
        linksPage.clickNoContentLink();
        String[] noContentResponse = linksPage.getResponse("204", "No Content");
        Assert.assertEquals(noContentResponse[0], "204");
        Assert.assertEquals(noContentResponse[1], "No Content");

        // Test moved link and response
        linksPage.clickMovedLink();
        String[] movedLinkResponse = linksPage.getResponse("301", "Moved Permanently");
        Assert.assertEquals(movedLinkResponse[0], "301");
        Assert.assertEquals(movedLinkResponse[1], "Moved Permanently");

        // Test bad request link and response
        linksPage.clickBadRequestLink();
        String[] badRequestLinkResponse = linksPage.getResponse("400", "Bad Request");
        Assert.assertEquals(badRequestLinkResponse[0], "400");
        Assert.assertEquals(badRequestLinkResponse[1], "Bad Request");

        // Test unauthorized link and response
        linksPage.clickUnauthorizedLink();
        String[] unauthorizedLinkResponse = linksPage.getResponse("401", "Unauthorized");
        Assert.assertEquals(unauthorizedLinkResponse[0], "401");
        Assert.assertEquals(unauthorizedLinkResponse[1], "Unauthorized");

        // Test forbidden link and response
        linksPage.clickForbiddenLink();
        String[] forbiddenLinkResponse = linksPage.getResponse("403", "Forbidden");
        Assert.assertEquals(forbiddenLinkResponse[0], "403");
        Assert.assertEquals(forbiddenLinkResponse[1], "Forbidden");

        // Test not found link and response
        linksPage.clickNotFoundLink();
        String[] notFoundLinkResponse = linksPage.getResponse("404", "Not Found");
        Assert.assertEquals(notFoundLinkResponse[0], "404");
        Assert.assertEquals(notFoundLinkResponse[1], "Not Found");

    }
}
