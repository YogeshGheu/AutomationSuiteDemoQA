package tests.elementsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.base.BaseTest;
import pages.homepage.Homepage;
import pages.subPages.elements.childPages.RadioButtonPage;

public class RadioButtonsTest extends BaseTest {
    @Test(description = "Test Radio Button Functionality")
    public void testRadioButtons(){
        Homepage homepage = new Homepage(getDriver());

        // get radio button page
        RadioButtonPage radioButtonPage = homepage.clickElementsTile().clickRadioButtonLabelFromDropdown();

        // perform test

        // test yes radio button
        boolean isYesRadioSelected = radioButtonPage.clickYesRadio();
        // assertions
        Assert.assertTrue(isYesRadioSelected);
        Assert.assertEquals(radioButtonPage.getOutputText(), "Yes");

        // test impressive radio button
        boolean isImpressiveRadioButtonSelected = radioButtonPage.clickImpressiveRadio();
        // assertions
        Assert.assertTrue(isImpressiveRadioButtonSelected);
        Assert.assertEquals(radioButtonPage.getOutputText(), "Impressive");

        // test the disabled no radio button
        Assert.assertFalse(radioButtonPage.isNoRadioClickable());

    }
}
