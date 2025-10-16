package pages.subPages.forms.childPages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utilities.ActionsUtility;
import utilities.SelectUtility;
import utilities.WaitUtility;

import javax.swing.*;
import java.io.File;

@Slf4j
public class PracticeFormPage extends BasePage {

    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By userEmailField = By.id("userEmail");
    private final By maleRadioButton = By.xpath("//label[@for=\"gender-radio-1\"]");
    private final By femaleRadioButton = By.xpath("//label[@for=\"gender-radio-2\"]");
    private final By userPhoneNumber = By.id("userNumber");


    private final By subjectsField = By.id("subjectsInput");

    private final By hobbiesSportCheckbox = By.xpath("//label[@for=\"hobbies-checkbox-1\"]");
    private final By hobbiesReadingCheckbox = By.xpath("//label[@for=\"hobbies-checkbox-2\"]");
    private final By hobbiesMusicCheckbox = By.xpath("//label[@for=\"hobbies-checkbox-3\"]");

    private final By pictureUploadButton = By.id("uploadPicture");

    private final By currentAddress = By.id("currentAddress");

    private final By stateField = By.xpath("//div[text()=\"Select State\"]");

    private final By cityField = By.xpath("//div[text()=\"Select City\"]");
    private final By cityKarnal = By.id("react-select-4-option-0");

    private final By submitButton = By.id("submit");

    private final By tanksHeading = By.xpath("//div[text()=\"Thanks for submitting the form\"]");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstNameField(String firstName) {
        sendKeys(firstNameField, firstName);
    }

    public void setLastNameField(String lastName) {
        sendKeys(lastNameField, lastName);
    }

    public void setUserEmailField(String email) {
        sendKeys(userEmailField, email);
    }

    public void clickMaleRadioButton() {
        click(maleRadioButton);
    }

    public void clickFemaleRadioButton() {
        click(femaleRadioButton);
    }

    public void setUserPhoneNumber(String phoneNumber) {
        sendKeys(userPhoneNumber, phoneNumber);
    }

    public void setDateOfBirth(int date, String month, int year) {
        By dateOfBirthField = By.id("dateOfBirthInput");
        By dateOfBirthMonthSelector = By.className("react-datepicker__month-select");
        By dateOfBirthYearSelector = By.className("react-datepicker__year-select");
        By dayOfMonth = By.xpath("//div[text()=" + date + "and contains(@aria-label, " + month + ")]");

        click(dateOfBirthField);
        SelectUtility.selectByVisibleText(find(dateOfBirthMonthSelector), month);
        SelectUtility.selectByVisibleText(find(dateOfBirthYearSelector), String.valueOf(year));
        click(dayOfMonth);
    }

    public void setSubjects() {
        click(subjectsField);
        sendKeys(subjectsField, "Hin");
        click(By.xpath("//div[text()='Hindi']"));
        sendKeys(subjectsField, "Eng");
        click(By.xpath("//div[text()='English']"));
    }

    public void setHobbies(boolean Sports, boolean Reading, boolean Music) {
        if (Sports) click(hobbiesSportCheckbox);
        if (Reading) click(hobbiesReadingCheckbox);
        if (Music) click(hobbiesMusicCheckbox);
    }

    public void uploadPicture(String filePath) {
        File file = new File(filePath);
        String absolutePath = file.getAbsolutePath();
        sendKeys(pictureUploadButton, absolutePath);
    }

    public void setCurrentAddress(String address) {
        sendKeys(currentAddress, address);
    }

    public void selectState(String state) {
//        By stateLocator = ;
        click(stateField);
        sendKeys(By.id("react-select-3-input"), state);
        click(By.xpath("//div[text()=\"" + state + "\"]"));
    }

    public void selectCity(String city){
//        By cityLocator = ;
        click(cityField);
        sendKeys(By.id("react-select-4-input"), city);
        click(By.xpath("//div[text()=\"" + city + "\"]"));
    }

    public void submitForm(){
        click(submitButton);
    }

    public boolean isTanksPopupDisplayed(){
        return find(tanksHeading).isDisplayed();
    }
}
