package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class  WaitManager {
    private WebDriver driver;

    public WaitManager(WebDriver driver) {
        this.driver = driver;
    }
    public FluentWait<WebDriver> fluentWait(){
        return new FluentWait<>(driver).
                withTimeout(java.time.Duration.ofSeconds(Long.parseLong("10"))).
                pollingEvery(java.time.Duration.ofSeconds(2)).
                ignoreAll(getExceptions());
    }
    private ArrayList<Class<? extends Exception>> getExceptions(){
        ArrayList<Class <? extends Exception>> exceptionsToIgnore = new ArrayList<>();
        exceptionsToIgnore.add(NoSuchElementException.class);
        exceptionsToIgnore.add(StaleElementReferenceException.class);
        exceptionsToIgnore.add(ElementNotInteractableException.class);
        exceptionsToIgnore.add(ElementClickInterceptedException.class);
        return exceptionsToIgnore;
    }

}
