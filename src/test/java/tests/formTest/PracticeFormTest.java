package tests.formTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.forms.childPages.PracticeFormPage;
import utilities.WaitUtility;

public class PracticeFormTest extends BaseTest {

    @Test(description = "Test practice form page")
    public void testPracticeForm(){
        PracticeFormPage formsPage = new Homepage(getDriver()).clickFormsTile().clickTileElementPracticeForm();
        formsPage.setFirstNameField("Yogesh");
        formsPage.setLastNameField("Gheu");
        formsPage.setUserEmailField("yogeshgheu@gmail.com");
        formsPage.clickMaleRadioButton();
        formsPage.setUserPhoneNumber("9898989898");
        formsPage.setDateOfBirth(6, "June", 2001);

        formsPage.setSubjects();
        formsPage.setHobbies(true, false, true);

        formsPage.uploadPicture("/Users/yogeshgheu/Downloads/account.jpeg");

        formsPage.setCurrentAddress(
                "City - Hisar\n" +
                "State - Haryana\n"+
                "Country - India"
        );

        formsPage.selectState("Haryana");
        formsPage.selectCity("Karnal");

        formsPage.submitForm();

        Assert.assertTrue(formsPage.isTanksPopupDisplayed());
    }
}
