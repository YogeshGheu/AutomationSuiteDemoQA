package utilities;

public class SwitchToUtility extends BaseUtility {

     public static void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }

    public static void sendTextToAlert(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }

    public static String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

}
