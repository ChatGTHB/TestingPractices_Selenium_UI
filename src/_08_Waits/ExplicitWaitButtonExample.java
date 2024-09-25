package _08_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BaseDriver;

import java.time.Duration;

public class ExplicitWaitButtonExample extends BaseDriver {

    /**
     Task 3: Explicit Wait (Button Click)
     Görev:

     "https://the-internet.herokuapp.com/dynamic_loading/2" sitesine gidiniz.
     Start butonuna tıklayınız.
     Dinamik olarak yüklenecek Hello World! yazısını bekleyiniz ve yazının görünür olduğunu doğrulayınız.

     Çözüm:
     Bu task'ta, Explicit Wait kullanarak dinamik olarak yüklenen bir elementin görünür olmasını bekleyeceğiz.
     */

    @Test
    public void explicitWaitButtonTask() {
        // 1. Adım: Web sitesine git
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        // 2. Adım: "Start" butonuna tıkla
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();

        // 3. Adım: Explicit Wait tanımla (10 saniye)
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 4. Adım: "Hello World!" yazısının görünmesini bekle
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        System.out.println("helloWorldText.getText() = " + helloWorldText.getText());

        // 5. Adım: Yazının göründüğünü doğrula
        Assert.assertTrue("'Hello World!' yazısı görünmedi!",helloWorldText.isDisplayed());

        waitAndClose();  // Tarayıcıyı kapat
    }
}
