package steps;

import pages.BookingPage;
import org.openqa.selenium.WebDriver;

public class BookingSteps extends BookingPage {
    public BookingSteps(WebDriver driver) {
        super(driver);
}

    public void inputCity(){
        searchLocal.sendKeys("Limerick");

    }
}
