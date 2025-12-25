package StepDefinitions;

import Utils.chromeOptionsManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

        public static WebDriver driver;

        @Before
        public void setUp() {
            driver = new ChromeDriver(chromeOptionsManager.getChromeOptions());
            }

        @After
        public void tearDown() {
                driver.quit();
            }
        }
