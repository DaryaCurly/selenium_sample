package objects;

import control.ControlWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searcher extends Constructor{

    private final Logger LOGGER = LogManager.getLogger();
    private DatePicker datePicker;

    @FindBy(id = "origin")
    private WebElement origin;

    @FindBy(id ="destination")
    private WebElement destination;

    @FindBy(css = "[data-test-id=\"departure-date-field\"]")
    private WebElement departure;

    @FindBy(css = "[data-test-id=\"return-date-field\"]")
    private WebElement returning;

    @FindBy(css = "[data-test-id=\"form-submit\"]")
    private WebElement searchButton;

    public Searcher(WebDriver driver) {
        super(driver);
        datePicker = new DatePicker(driver);
    }

    /**
     * Указать место отправления
     * @param value - город, из ктр осуществляется вылет
     */
    public void setOrigin(String value){
        ControlWait.waitElementEnabled(origin);
        origin.clear();
        origin.sendKeys(value);
        LOGGER.info("City of departure was set: " + value);
    }

    /**
     * Указать место назначения
     * @param value - город, в ктр ищем рейс
     */
    public void setDestination(String value){
        destination.sendKeys(value);
        LOGGER.info("City of destination was set: " + value);
    }

    /**
     * выбор даты отправки
     * это всегда будет в след. месяце, с целью не привязываться к дате
     * чтобы она не устарела и тест оставался актуальным
     */
    public void selectDepartureDate () {
        ControlWait.waitElementEnabled(departure);
        departure.click();
        departure.click();
        LOGGER.info("Departure datepicker was opened");
        datePicker.selectDeparture();
    }

    /**
     * выбор даты возвращения
     */
    public void selectReturnDate() {
        returning.click();
        LOGGER.info("Return datepicker was opened");
        datePicker.selectReturn();
    }

    /**
     * Кликнуть кнопку поиска билетов
     */
    public void submitSearch() {
        searchButton.click();
        LOGGER.info("Search was submitted");
    }
}
