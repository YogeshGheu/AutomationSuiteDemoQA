package pages.subPages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class PracticeFormPage extends BasePage {

    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By userEmailField = By.id("userEmail");
    private final By maleRadioButton = By.id("gender-radio-1");
    private final By femaleRadioButton = By.id("gender-radio-2");
    private final By userPhoneNumber = By.id("userNumber");

    private final By dateOfBirthField = By.id("dateOfBirthInput");
    private final By dateOfBirthMonthSelector = By.className("react-datepicker__month-select");
    private final By dateOfBirthYearSelector = By.className("react-datepicker__year-select");
    private final By sixthJuneInCalendar = By.xpath("//div[@class=\"react-datepicker__week\"]/child::div[@aria-label=\"Choose Wednesday, June 6th, 2001\"]");

    private final By subjectsField = By.xpath("//div[contains(@class, \"subjects-auto-complete__control\")]");

    private final By hobbiesSportCheckbox = By.id("hobbies-checkbox-1");
    private final By hobbiesReadingCheckbox = By.id("hobbies-checkbox-2");
    private final By hobbiesMusicCheckbox = By.id("hobbies-checkbox-3");

    private final By pictureUploadButton = By.id("uploadPicture");

    private final By currentAddress = By.id("currentAddress");

    private final By stateField = By.id("state");
    



    public PracticeFormPage(WebDriver driver){
        super(driver);
    }





}
