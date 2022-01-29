package rahulshettyacademy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.PageComponents.MultiCityTrip;
import rahulshettyacademy.PageComponents.OneWayTrip;
import rahulshettyacademy.PageComponents.RoundTrip;
import rahulshettyacademy.PageObjects.TravelHomePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest {
    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");
    TravelHomePage thPage;
@BeforeTest
public void setup()
{
    driver= initializeDriver();
    thPage= new TravelHomePage(driver);
}

@Test(dataProvider="getData")
public void flightTest(HashMap<String, String> reservationDetails) throws InterruptedException {


    thPage.goTo();
    System.out.println(thPage.getFooter().getFlightAttribute());
    System.out.println(thPage.getNavigationBar().getFlightAttribute());
    System.out.println(thPage.getFooter().getLinkCount());
    System.out.println(thPage.getNavigationBar().getLinkCount());


  //  thPage.setBookingStrategy("roundtrip");
    //thPage.checkAvailability("MAA", "JAI");
    thPage.setBookingStrategy("multicitytrip");


    thPage.checkAvailability(reservationDetails);
    thPage.setBookingStrategy("OneWayTrip");
    thPage.checkAvailability(reservationDetails);

}

@AfterTest
public void tearDown()
{
    driver.quit();
}

@DataProvider
    public Object[][] getData() throws IOException {
    List<HashMap<String, String>> l = getJsonData(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//DataSet//reservationDetails.json");
    return new Object[][]
    {
            {l.get(0)}, {l.get(1)}

};
}
}
