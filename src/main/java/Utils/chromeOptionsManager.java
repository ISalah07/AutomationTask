package Utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class chromeOptionsManager {
    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("user-data-dir=C:/Temp/ChromeProfile" + System.currentTimeMillis());


        return options;
    }
}
