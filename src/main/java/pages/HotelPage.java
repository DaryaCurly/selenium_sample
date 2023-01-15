package pages;

import control.ControlWait;
import objects.Constructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HotelPage extends Constructor {

    @FindBy(css = "a.Logo-module__logo_position_first--Pqbab")
    private WebElement logo;

    public HotelPage(WebDriver driver) {
        super(driver);
    }

    public void checkLogoIsDisplayed() {
        ControlWait.waitElementVisible(logo);
        Assert.assertTrue(logo.isDisplayed());
    }
}
