package pages.subPages.elements.childPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.subPages.elements.ElementsPage;

public class TextBoxPage extends ElementsPage {
    private final By textPageHeading = By.xpath("//h1[text()=\"Text Box\"]");
    private final By fullNameField = By.id("userName");
    private final By userEmailField = By.id("userEmail");
    private final By currentAddressField = By.id("currentAddress");
    private final By permanentAddressField = By.id("permanentAddress");
    private final By submitButton = By.id("submit");

    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    private final By outputName = By.xpath("//div[@id=\"output\"]/descendant::p[@id=\"name\"]");
    private final By outputEmail = By.xpath("//div[@id=\"output\"]/descendant::p[@id=\"email\"]");
    private final By outputCurrentAddress = By.xpath("//div[@id=\"output\"]/descendant::p[@id=\"currentAddress\"]");
    private final By outputPermanentAddress = By.xpath("//div[@id=\"output\"]/descendant::p[@id=\"permanentAddress\"]");


    public TextBoxPage(WebDriver driver){
        super(driver);
    }

    public boolean isTextBoxPageHeadingVisible(){
        return find(textPageHeading).isDisplayed();
    }

    public void sendTextInFullNameField(String fullName){
        this.fullName = fullName;
        sendKeys(fullNameField, fullName);
    }

    public void sendTextInUserEmailField(String email){
        this.email = email;
        sendKeys(userEmailField, email);
    }

    public void sendTextInCurrentAddressField(String currentAddress){
        this.currentAddress = currentAddress;
        sendKeys(currentAddressField, currentAddress);
    }

    public void sendTextInPermanentAddressField(String permanentAddress){
        this.permanentAddress = permanentAddress;
        sendKeys(permanentAddressField, permanentAddress);
    }

    public void clickSubmitButton(){
        click(submitButton);
    }

    // convenience method

    public void fillAndSubmitTextBoxForm(String fullName, String email, String currentAddress, String permanentAddress){
        sendTextInFullNameField(fullName);
        sendTextInUserEmailField(email);
        sendTextInCurrentAddressField(currentAddress);
        sendTextInPermanentAddressField(permanentAddress);
        clickSubmitButton();
    }

    // validations

    public boolean isOutputFullNameCorrect(){
        return find(outputName).getText().contains(fullName);
    }

    public boolean isOutputEmailCorrect(){
        return find(outputEmail).getText().contains(email);
    }

    public boolean isOutputCurrentAddressCorrect(){
        return find(outputCurrentAddress).getText().contains(currentAddress);
    }

    public boolean isOutputPermanentAddressCorrect(){
        return find(outputPermanentAddress).getText().contains(permanentAddress);
    }

    public boolean validateCompleteOutput(){
        boolean validationResult =  isOutputFullNameCorrect()
                && isOutputEmailCorrect()
                && isOutputCurrentAddressCorrect()
                && isOutputPermanentAddressCorrect();

        System.out.println(validationResult ? "validation is done - data is correct" : "validation not done - incorrect data !");
        return validationResult;
    }

}
