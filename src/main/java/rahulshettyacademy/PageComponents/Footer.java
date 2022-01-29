package rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class Footer extends AbstractComponent {
    WebDriver driver;
    //method to handle flight footer
    //when selenium executes any method is in this class
    //scope of the selenium should be in footer only

     By flights= By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public Footer(WebDriver driver, By sectionElement) {
        //whenever we inherit from parent class then we need to invoke parent class constructor in our own child
        // class constructor
        super(driver, sectionElement);
    }

    public String getFlightAttribute()
   {
       //need to create custom findElement to reduce the scope to footer section.
       return findElement(flights).getAttribute("class");
       //driver.findElement(flights).click();
   }

    public int getLinkCount()
    {
                   return findElements(links).size();
    }

}
