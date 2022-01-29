package rahulshettyacademy.PageComponents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rahulshettyacademy.AbstractComponents.AbstractComponent;
import rahulshettyacademy.AbstractComponents.SearchFlightAvailability;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiCityTrip extends AbstractComponent implements SearchFlightAvailability {
    WebDriver driver;
    private By multicityPopup = By.id("MultiCityModelAlert");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By to2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    private By searchBtn= By.cssSelector("#ctl00_mainContent_btn_FindFlights");
    private By multicityRadio=By.id("ctl00_mainContent_rbtnl_Trip_2");

    public MultiCityTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails) throws InterruptedException {
        makeStateReady(s->selectOrigin(reservationDetails.get("origin")));
        selectDestination(reservationDetails.get("destination"));

        selectOrigin2(reservationDetails.get("origin2"));
        selectDestination2(reservationDetails.get("destination2"));
        findElement(searchBtn).click();

        Alert alt= driver.switchTo().alert();
        alt.accept();


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
    public void selectOrigin2(String origin2) throws InterruptedException {
       Thread.sleep(5000);
        findElement(from2).click();
        findElement(By.xpath("//a[@value='"+origin2+"']")).click();
    }

    public void selectDestination2(String destination2)
    {
        findElement(to2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    public void makeStateReady (Consumer<MultiCityTrip> consumer)
    {
        //common pre-requisites
        // write actual function - check availability, calendar function etc.
        //Tear down

        System.out.println("In checkAvailability method of MulticityTrip class");
        findElement(multicityRadio).click();
        findElement(multicityPopup).click();
        waitTillComponentDisapear(multicityPopup);
        consumer.accept(this);
        System.out.println("I am done with execute around pattern");


    }
}
