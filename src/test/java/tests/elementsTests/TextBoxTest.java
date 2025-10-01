package tests.elementsTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.elements.childPages.TextBoxPage;

public class TextBoxTest extends BaseTest {
    @Test(description = "test the text box functionality")
    public void testTextBox() throws RuntimeException{
        TextBoxPage textBoxPage = new Homepage(BaseTest.getDriver()).clickElementsTile().clickTextBoxLabelFromDropdown();
        Assert.fail();
        textBoxPage.fillAndSubmitTextBoxForm("Yogesh Gheu", "yogeshgheu@gmail.com", "Hisar", "Hisar, Haryana");
        Assert.assertTrue(textBoxPage.validateCompleteOutput());
        throw new RuntimeException("hello");

    }
}
