package test_cases;

import control.ControlWait;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SearchTicketsForNextMonth extends BaseTest {


    @Test(description = "Search tickets")
    public static void setSearchingParameters() {
        searcher.setOrigin("Санкт-Петербург");
        searcher.setDestination("Ереван");
        searcher.selectDepartureDate();
        searcher.selectReturnDate();
        searcher.submitSearch();
    }

    @Test(description = "Check results of search were opened in new tab", dependsOnMethods = "setSearchingParameters")
    public static void checkTabs() {
//        Дождаться, когда бцдцт открыты 2 вкладки
        ControlWait.waitSizeOfArray(new ArrayList<>(DRIVER.getWindowHandles()), 2);
//        Собрать вкладки в массив, когда их будет необходимое колличество
        ArrayList<String> tabs = new ArrayList<>(DRIVER.getWindowHandles());
//        Открыть 1ю вкладку в браузере
        DRIVER.switchTo().window(tabs.get(0));
//        Дождаться отображения логотипа
        hotelPage.checkLogoIsDisplayed();
//        Проверить, что url этой вкладки содержит слово 'hotel'
        ControlWait.waitForText(DRIVER.getCurrentUrl(), "hotel");
//        Открыть вторую вкладку
        DRIVER.switchTo().window(tabs.get(1));
//        Проверить, что url этой вкладки содержит 'aviasales.ru'
        ControlWait.waitForText(DRIVER.getCurrentUrl(), "aviasales.ru");
    }
}
