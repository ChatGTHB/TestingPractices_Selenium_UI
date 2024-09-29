package _01_SeleniumIntro;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

public class NinjaRegisterTest extends BaseDriver {

    @Test
    public void registerTest() {
        // 1. "http://tutorialsninja.com/demo/" sitesine gidin
        driver.get("http://tutorialsninja.com/demo/");

        // 2. Sağ üstteki "My Account" menüsüne tıklayın ve "Register" bağlantısını seçin
        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement myAccount = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();

        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        // 3. İlk adınızı (First Name) girin
        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("John");

        // 4. Soyadınızı (Last Name) girin
        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Doe");

        // 5. E-posta adresinizi (Email) girin
        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("test" + ((int) (Math.random() * 10000)) + "@test.com");

        // 6. Telefon numaranızı (Telephone) girin
        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("1234567890");

        // 7. Şifrenizi (Password) girin ve şifre tekrarını (Password Confirm) girin
        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Password123");

        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("Password123");

        // 8. "Privacy Policy" kutucuğunu işaretleyin
        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement privacyPolicy = driver.findElement(By.name("agree"));
        privacyPolicy.click();

        // 9. "Continue" butonuna tıklayın ve tarayıcıyı kapatın
        MyFunction.wait(2);  // Neticeyi görmek için kısa bekleme
        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

        // Belirli bir süre bekleyip tarayıcıyı kapatıyoruz
        waitAndClose();
    }
}
