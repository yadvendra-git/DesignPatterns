package rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rahulshettyacademy.PageComponents.MultiCityTrip;
import rahulshettyacademy.PageComponents.OneWayTrip;
import rahulshettyacademy.PageComponents.RoundTrip;

//Factory design pattern over Strategy design pattern
public class StrategyFactor {
WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");
    public StrategyFactor(WebDriver driver) {
        this.driver=driver;
    }

    public SearchFlightAvailability createStrategy (String strategyType)

    {
        if (strategyType.equalsIgnoreCase("RoundTrip"))
        {
            return new RoundTrip(driver, sectionElement);
        }

       else if (strategyType.equalsIgnoreCase("MultiCityTrip"))
        {
            return new MultiCityTrip(driver, sectionElement);
        }
       else if (strategyType.equalsIgnoreCase("OneWayTrip"))
        {
            return new OneWayTrip();
        }
       return null;

    }


}
