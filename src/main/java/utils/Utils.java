package utils;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.List;

public class Utils {

    private WebDriver driver;
    private FluentWait wait;
    public Utils(WebDriver driver){
        this.driver = driver;
        this.wait = new FluentWait(driver).
                withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOnElement(WebElement element){
        waitForElement(element);
        element.click();
    }

    public void insertOnElement(WebElement element, String value){
        waitForElement(element);
        element.sendKeys(value);
    }

    protected void selectElement(List<WebElement> element, String value){
        element.forEach(e -> {
            waitForElement(e);
            if(e.getText().equalsIgnoreCase(value)) clickOnElement(e);
        });
    }

    public FluentWait getWait(){
        return this.wait;
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}