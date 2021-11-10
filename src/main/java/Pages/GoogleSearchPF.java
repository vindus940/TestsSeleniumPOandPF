package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchPF {

    private WebDriver chromeDriver;

    @FindBy(how= How.XPATH, using = "//input[@class='gLFyf gsfi']")
    private WebElement searchField;

    public GoogleSearchPF(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
    }

    public void findPF (String keysFind){
        searchField.click();
        searchField.sendKeys(keysFind);
        searchField.sendKeys(Keys.ENTER);
    }

    public void findWikiPF() {
        List<WebElement> WikiLinkPF = chromeDriver.findElements(By.xpath("//a[@href='https://ru.wikipedia.org/wiki/%D0%A8%D0%BF%D0%B0%D0%B6%D0%BD%D0%B8%D0%BA']"));
        int size = WikiLinkPF.size();
        assertTrue(size > 0, "link not exists");

        assertTrue(WikiLinkPF.stream().anyMatch(x->x.getText().contains("ru.wikipedia.org")),"wiki was not found");
    }
}
