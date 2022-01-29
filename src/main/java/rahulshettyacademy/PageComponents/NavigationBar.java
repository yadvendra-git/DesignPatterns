package rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent {
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");


    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    public String getFlightAttribute() {
        //need to create custom findElement to reduce the scope to footer section.
        return findElement(flights).getAttribute("class");

    }

    public int getLinkCount()
    {
        return findElements(links).size();
    }
}