package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// общий конструктор для Page Object, чтобы не дублировать driver и PageFactory в каждом классе
public class Constructor {

    WebDriver driver;

    public Constructor(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
