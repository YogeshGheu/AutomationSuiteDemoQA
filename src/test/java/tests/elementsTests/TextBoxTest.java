package tests.elementsTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.elements.childPages.TextBoxPage;

public class TextBoxTest extends BaseTest {
    @Test
    public void testTextBox(){
        TextBoxPage textBoxPage = new Homepage(getDriver()).clickElementsTile().clickTextBoxLabelFromDropdown();
        textBoxPage.fillAndSubmitTextBoxForm("Yogesh Gheu", "yogeshgheu@gmail.com", "Hisar", "Hisar, Haryana");
        Assert.assertTrue(textBoxPage.validateCompleteOutput());
    }
}
