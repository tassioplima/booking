package steps;

import org.openqa.selenium.WebDriver;
import pages.BookingPage;

public class BookingSteps extends BookingPage {
    public BookingSteps(WebDriver driver) {
        super(driver);}


    public void inputCity(){
        searchLocal.sendKeys("Limerick");

    }
}