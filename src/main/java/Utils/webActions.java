package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class webActions {
    protected WebDriver driver;
    private WaitManager waitManager;

    public webActions(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver);
    }

    public void NavigateTo(String url) {
        driver.navigate().to(url);
    }
    public WebElement FindElement(By locator) {
        return driver.findElement(locator);
    }
    public void ScrollToElement(By Locator){
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(""" 
                arguments[0].scrollIntoView({behavior:"auto",block:"center",inline:"center"});""", FindElement(Locator));
    }


    public void submit(By Locator){
        waitManager.fluentWait().until(
                d ->{
                    try {
                        WebElement element = d.findElement(Locator);
                        element.submit();
                        return  true;
                    }
                    catch (Exception e){
                        return false;
                    }
                }
        );

    }
    public void type(By Locator, String text){
        waitManager.fluentWait().until(
                d ->{
                    try {
                        WebElement element = d.findElement(Locator);
                        new Actions(d).scrollToElement(element);
                        element.clear();
                        element.sendKeys(text);
                        return  true;
                    }
                    catch (Exception e){
                        return false;
                    }
                }
        );

    }
    public String getText(By Locator){
        return  waitManager.fluentWait().until(
                d ->{
                    try {
                        WebElement element = d.findElement(Locator);
                        ScrollToElement(Locator);
                        String msg = element.getText();
                        return !msg.isEmpty() ? msg : null;
                    }
                    catch (Exception e){
                        return null;
                    }
                }
        );
    }
    public void verifyEquals(Object actual, Object expected, String message) {
        if (!actual.equals(expected)) {
            throw new AssertionError(message + " | Expected: " + expected + ", Actual: " + actual);
        }
    }



}
