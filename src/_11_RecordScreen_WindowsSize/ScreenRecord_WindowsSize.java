package _11_RecordScreen_WindowsSize;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utility.BaseDriver;
import utility.MyFunction;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class ScreenRecord_WindowsSize extends BaseDriver {

    @Test
    public void test() throws IOException {

        driver.get("https://www.facebook.com/");

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
        WebElement button = driver.findElement(By.xpath("//button[@name='login']"));

        email.sendKeys("asdasdasd");
        pass.sendKeys("asdasdasd");
        button.click();

        List<WebElement> errMsg = driver.findElements(By.xpath("//*[text()='Wrong credentials']"));

        if (errMsg.size() > 0) {
            System.out.println("Hata alindi ");

            MyFunction.wait(3);

            // Adjusting the screen size (Window Size)
            Dimension dimension = new Dimension(1000, 1000);
            driver.manage().window().setSize(dimension);

            TakesScreenshot ts = (TakesScreenshot) driver;
            File hafiza = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(hafiza, new File("screenshott\\Gecersiz_giris.jpg"));
        }
        waitAndClose();
    }
}

// Todo : Hata aldiginizda ekran resmi yerine ekran videosu alma .
