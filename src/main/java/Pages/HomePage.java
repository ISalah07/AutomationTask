package Pages;

import Utils.webActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends webActions {

        public HomePage(WebDriver driver) {
            super(driver);
        }

        private By searchBox = By.name("q");
        private By searchResults = By.cssSelector(".LC20lb.MBeuO.DKV0Md");

        public void openPage() {
            NavigateTo("https://www.google.com");
        }


        public void searchFor(String text) {
            type(searchBox, text);
        }

        public void submitSearch() {
            submit(searchBox);
                }

                public void verifyCurrentUrl(String expectedUrl) {
            String currentUrl = driver.getCurrentUrl();
            String expectedInUrl = expectedUrl.toLowerCase().replace(" ", "+");
            verifyEquals(currentUrl.toLowerCase().contains(expectedInUrl), true, "Search Results do not match"+currentUrl);
        }


        public void verifySearchResults(String SearchResults) {
            String searchResult = getText(searchResults);
            verifyEquals(searchResult.toLowerCase().contains(SearchResults.toLowerCase()), true, "Search Results do not match"+searchResult);


        }


    }

