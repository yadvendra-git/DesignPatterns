package rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rahulshettyacademy.AbstractComponents.SearchFlightAvailability;
import rahulshettyacademy.AbstractComponents.StrategyFactor;
import rahulshettyacademy.PageComponents.Footer;
import rahulshettyacademy.PageComponents.NavigationBar;
import rahulshettyacademy.PageComponents.OneWayTrip;

import java.util.HashMap;

public class TravelHomePage {
    By sectionElement= By.cssSelector("div#traveller-home");   //This represents complete footer section
    By navSectionElement= By.cssSelector("#buttons");
    WebDriver driver;
    SearchFlightAvailability searchFlightAvailability;

    public TravelHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    public NavigationBar getNavigationBar()
    {
        return new NavigationBar(driver, navSectionElement);
    }

    public Footer getFooter()
    {
        return new Footer(driver, sectionElement);
    }

    public void setBookingStrategy(String strategyType) {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvailability =strategyFactor.createStrategy(strategyType);
        this.searchFlightAvailability = searchFlightAvailability;
    }

    public void checkAvailability(HashMap<String, String> reservationDetails) throws InterruptedException {

        searchFlightAvailability.checkAvailability(reservationDetails);
    }

    public String getTitle()
    {
        return driver.getTitle();
    }
}
