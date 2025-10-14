package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility extends BaseUtility{

    public static void selectByVisibleText(WebElement selectElement, String text){
        Select select = new Select(selectElement);
        select.selectByVisibleText(text);
    }
}
