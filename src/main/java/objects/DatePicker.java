package objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DatePicker extends Constructor{


    private final Logger LOGGER = LogManager.getLogger();
    private final static By DAY = new By.ByCssSelector(".calendar__day-cell");

    @FindBy(css = "button.--next")
    private WebElement buttonNext;

    @FindBy(css = ".calendar__month")
    private List<WebElement> months;

    DatePicker(WebDriver driver) {
        super(driver);
    }

    void selectDeparture() {
        buttonNext.click();
        months.get(0).findElements(DAY).get(6).click();
        LOGGER.info("First Sunday of month was selected");
    }

    void selectReturn() {
        months.get(1).findElements(DAY).get(6).click();
        LOGGER.info("First Sunday of month was selected");
    }
}
