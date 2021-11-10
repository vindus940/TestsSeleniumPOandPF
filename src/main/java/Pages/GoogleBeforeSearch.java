package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleBeforeSearch {

    protected WebDriver chromeDriver;

    private WebElement searchField;

    public GoogleBeforeSearch(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
    }

    public void find (String keysFind){
        searchField.click();
        searchField.sendKeys(keysFind);
        searchField.sendKeys(Keys.ENTER);
    }
}
