package control;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.given;

public class ControlWait {

//    В каждом классе свой логгер, чтобы было понятно, какой класс отработал и откуда мы получаем информацию
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Дождаться и проверить, что массив необходимого размера
     * @param list - массив для проверки
     * @param expectedSize - ожидаемое кол-во элементов в массиве
     */
    public static void waitSizeOfArray(ArrayList<Object> list, int expectedSize) {
        given().ignoreExceptions().await().atMost(15, TimeUnit.SECONDS).untilAsserted(() ->
                Assert.assertEquals(list.size(), expectedSize));
        LOGGER.info(String.format("Array has expected size: %d", expectedSize));
    }

    /**
     * Дождаться проверки, когда необходимый текст будет отображен
     * @param contains - общая строчка, которая должна содержать ожидаемый результат
     * @param presented - слово, ктр должно быть отображено в строчке
     */
    public static void waitForText(String contains, String presented) {
        LOGGER.info(contains);
        given().ignoreExceptions().await().atMost(15, TimeUnit.SECONDS).untilAsserted(() ->
                Assert.assertTrue(contains.contains(presented)));
        LOGGER.info(String.format("Value %s is presented", presented));
    }

    /**
     * Дождаться, чтобы элемент был доступен для взаимодействия
     * @param element - эл, ктр должен быть доступен для взаимодействия
     */
    public static void waitElementEnabled(WebElement element) {
        given().ignoreExceptions().await().atMost(15, TimeUnit.SECONDS).until(element::isEnabled);
    }

    /**
     * Дождаться, чтобы элемент был отображен на странице
     * @param element - необходимый для отображения элемент
     */
    public static void waitElementVisible(WebElement element) {
        given().ignoreExceptions().await().atMost(15, TimeUnit.SECONDS).until(element::isDisplayed);
    }
}
