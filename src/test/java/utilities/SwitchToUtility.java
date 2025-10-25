package utilities;

import pages.subPages.AFW.childPages.BrowserWindowsPage;

import java.util.Map;
import java.util.Set;

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

//    public static void switchToWindow() {
//        String currentWindowHandle = getDriver().getWindowHandle();
//        Set<String> allWindowHandles = getDriver().getWindowHandles();
//        for (String windowHandle : allWindowHandles) {
//            if (!currentWindowHandle.equals(windowHandle)) {
//                getDriver().switchTo().window(windowHandle);
//            }
//        }
//    }

    public static void switchToWindow(String windowHandleKey){
        getDriver().switchTo().window(BrowserWindowsPage.windowsIds.get(windowHandleKey));
    }

    public static void closeWindow(String windowHandleKey){
//        if(BrowserWindowsPage.windowsIds.containsValue(windowHandle)){
//            for(Map.Entry<String, String> entry: BrowserWindowsPage.windowsIds.entrySet()){
//                if(entry.getValue().equals(windowHandle)){
//                    BrowserWindowsPage.windowsIds.remove(entry.getKey());
//                }
//            }
//        }
        // safe approach, above will throw ConcurrentModificationException at runtime
//        BrowserWindowsPage.windowsIds.entrySet().removeIf(entry -> entry.getValue().equals(windowHandle));
//        remove the entries by key itself
        getDriver().switchTo().window(BrowserWindowsPage.windowsIds.get(windowHandleKey)).close();
        BrowserWindowsPage.windowsIds.remove(windowHandleKey);
    }
}
