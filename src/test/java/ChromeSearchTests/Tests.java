package ChromeSearchTests;

import Pages.GoogleAfterSearch;
import Pages.GoogleBeforeSearch;
import Pages.GoogleSearchPF;
import Pages.OpenSitePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends BaseTests {

    @Test
    public void googleSearchPO() {
        chromeDriver.get("https://www.google.com/");
        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(chromeDriver);
        googleBeforeSearch.find("Гладиолус");
        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(chromeDriver);
        googleAfterSearch.findWiki();
    }

    @Test
    public void googleSearchPF() {
        chromeDriver.get("https://www.google.com/");
        GoogleSearchPF googleSearchPF = PageFactory.initElements(chromeDriver, GoogleSearchPF.class);
        googleSearchPF.findPF("Гладиолус");
        googleSearchPF.findWikiPF();
    }

    @Test
    public void RateExchangePO(){
        chromeDriver.get("https://www.google.com/");
        GoogleBeforeSearch googleBeforeSearch = new GoogleBeforeSearch(chromeDriver);
        googleBeforeSearch.find("Открытие");
        GoogleAfterSearch googleAfterSearch = new GoogleAfterSearch(chromeDriver);
        googleAfterSearch.findOpen();
        chromeDriver.get("https://www.open.ru/");
        OpenSitePage openSitePage = new OpenSitePage(chromeDriver);
        openSitePage.exchangeRateAssert();
    }
}
