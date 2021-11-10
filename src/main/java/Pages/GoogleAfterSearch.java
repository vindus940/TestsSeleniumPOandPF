package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleAfterSearch {

    protected WebDriver chromeDriver;

    public GoogleAfterSearch(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;
    }

    public void findWiki() {
        List<WebElement> WikiLink = chromeDriver.findElements(By.xpath("//a[@href='https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA']"));
        int size = WikiLink.size();
        assertTrue(size > 0, "link not exists");

        assertTrue(WikiLink.stream().anyMatch(x->x.getText().contains("ru.wikipedia.org")),"wiki site was not found");
    }

    public void findOpen() {
        List<WebElement> OpenLink = chromeDriver.findElements(By.xpath("//a[@href='https://www.open.ru/']"));
        int size = OpenLink.size();
        assertTrue(size > 0, "link not exists");

        assertTrue(OpenLink.stream().anyMatch(x->x.getText().contains("open.ru")),"open site was not found");
    }
}