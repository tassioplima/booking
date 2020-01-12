package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class BookingPage extends Utils {
    public BookingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[type='search']")
    public WebElement searchLocal;

    @FindBy(css = "[data-bui-ref='calendar-next']")
    public WebElement nextCalendar;

}