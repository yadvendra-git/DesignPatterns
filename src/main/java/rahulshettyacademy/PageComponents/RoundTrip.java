package rahulshettyacademy.PageComponents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rahulshettyacademy.AbstractComponents.AbstractComponent;
import rahulshettyacademy.AbstractComponents.SearchFlightAvailability;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightAvailability {
WebDriver driver;

private By tripType= By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1");
private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
private By chkBox= By.id("familyandfriend");
private By searchBtn= By.cssSelector("#ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }



    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) {
        System.out.println("In checkAvailability method of RoundTrip class");
        findElement(tripType).click();
        findElement(from).click();
        selectOrigin(reservationDetails.get("origin"));
        selectDestination(reservationDetails.get("destination"));
        findElement(chkBox).click();
        findElement(searchBtn).click();
        driver.switchTo().alert().accept();

    }

    public void selectOrigin(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestination(String destination)
    {
        findElement(to).click();
       findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
