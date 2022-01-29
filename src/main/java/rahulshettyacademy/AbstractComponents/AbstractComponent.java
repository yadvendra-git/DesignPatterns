package rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {
    WebDriver driver;
WebElement sectionElement;  //local variable
    public AbstractComponent(WebDriver driver, By sectionElement) {

        //Assign local variable to sectionELement coming from TravelHomePage class so that this variable can be used
        //in findElement() method
this.driver=driver;
        this.sectionElement = driver.findElement(sectionElement);
    }



    public WebElement findElement(By findElementBy)
    {

        return sectionElement.findElement(findElementBy);
    }

    public List<WebElement> findElements(By findElementBy)
    {

        return sectionElement.findElements(findElementBy);
    }
    public void waitTillComponentDisapear (By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

    }

}
