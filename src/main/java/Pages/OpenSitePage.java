package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OpenSitePage {

    protected WebDriver chromeDriver;

    private String buyRateUSD;
    private String sellRateUSD;
    private String buyRateEUR;
    private String sellRateEUR;

    public OpenSitePage(WebDriver chromeDriver){
        this.chromeDriver = chromeDriver;

        buyRateUSD = chromeDriver.findElement(By.xpath("(//span[@class='main-page-exchange__rate'])[1]")).getText().replace(',', '.');
        sellRateUSD = chromeDriver.findElement(By.xpath("(//span[@class='main-page-exchange__rate'])[2]")).getText().replace(',', '.');
        buyRateEUR = chromeDriver.findElement(By.xpath("(//span[@class='main-page-exchange__rate'])[3]")).getText().replace(',', '.');
        sellRateEUR = chromeDriver.findElement(By.xpath("(//span[@class='main-page-exchange__rate'])[4]")).getText().replace(',', '.');
    }

    public void exchangeRateAssert (){

        float bUSDInt = Float.parseFloat(buyRateUSD);
        float sUSDInt = Float.parseFloat(sellRateUSD);
        float bEURInt = Float.parseFloat(buyRateEUR);
        float sEURInt = Float.parseFloat(sellRateEUR);

        assertTrue(sUSDInt > bUSDInt, "the selling rate is less than the buying rate, for USD.");
        assertTrue(sEURInt > bEURInt, "the selling rate is less than the buying rate, for EUR.");

    }
}