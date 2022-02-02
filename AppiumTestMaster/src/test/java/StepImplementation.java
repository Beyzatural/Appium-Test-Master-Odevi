import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StepImplementation extends BaseTest {

    public Logger logger = LogManager.getLogger(getClass().getName());

    @Step("<time> saniye kadar bekle")
    public void waitForseconds(int time) throws InterruptedException {
        Thread.sleep(time*1000);
    }

    /* @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textAreacontrol(String id,String text) {
        Assert.assertTrue("Element text değerini içermiyor", appiumDriver.findElement(By.id(id)).getText().contains(text));
    }
     */

    @Step("id <id> li elemente tıkla")
    public void clickByid(String id){
        appiumDriver.findElement(By.id(id)).click();
        logger.info("Id li elemente tıklandı");
    }

    @Step("xpath <xpath> li elemente tıkla")
    public void clickByxpath(String xpath){
       appiumDriver.findElement(By.xpath(xpath)).click();
        logger.info("Xpath li elemente tıklandı");
    }

    @Step("iki defa scroll et")
    public void ScrollRandomPos() {
        Dimension dimension = appiumDriver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);
        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);
        TouchAction touch = new TouchAction(appiumDriver);
        touch.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();
        logger.info("Scroll işlemi gerçekleşti");

    }

    @Step("Elementler <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomelement(String xpath){
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();
        logger.info("Pantolon kategorisindeki ürünlerden rastgele seçildi");
    }

    @Step("id <id> li elemente bul ve <text> değerini yaz")
    public void sendkeysByxpath(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        logger.info("Id li element bulundu ve text değeri yazıldı");
    }

}


