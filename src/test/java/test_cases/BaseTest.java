package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Searcher;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.HotelPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    private static ChromeOptions options;

    static WebDriver DRIVER;

    // объекты Page Object для использования в тестах
    static Searcher searcher;
    static HotelPage hotelPage;

//    Перед запуском тестов
    @BeforeSuite(alwaysRun = true)
    protected void setUpTest() {
//        Установить драйвер
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        DRIVER = new ChromeDriver(options);
//        Установить неявное ожидание 10 секунд
        DRIVER.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        // Открыть браузер размера 1280, 970
        DRIVER.manage().window().setSize(new Dimension(1280, 970));
        // Открыть Aviasales: https://www.aviasales.ru/
        DRIVER.get("https://www.aviasales.ru/");
        setUpPageObjects();
    }

//    инициализация объектов Page Object
    private void setUpPageObjects() {
        searcher = new Searcher(DRIVER);
        hotelPage = new HotelPage(DRIVER);
    }

// После завершения сьюта обязательное закрытие драйвера
    @AfterSuite(alwaysRun = true)
    protected void closeBrowser() {
        DRIVER.close();
        DRIVER.quit();
    }

}
