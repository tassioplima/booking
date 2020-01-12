package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public WebElement getElement(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }

    public List<WebElement> getElementList(String xpath) {
        List<WebElement> element = driver.findElements(By.xpath(xpath));
        return element;
    }
}
