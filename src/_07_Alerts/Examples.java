package _07_Alerts;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

public class Examples extends BaseDriver {

    Actions actions = new Actions(driver);

    /**
     * Test Senaryosu: Sağ Tıklama (Right Click) ve Çift Tıklama (Double Click) Aksiyonları
     *
     * Görevler:
     * 1. Sağ tıklama yapılacak bir element bul ve sağ tıkla.
     * 2. Sağ tıklama sonrası açılan context menüden "Copy" seçeneğine tıkla.
     * 3. "Copy" seçildikten sonra bir alert penceresi açılacak. Bu alert penceresini yakala ve kapat.
     * 4. Çift tıklama yapılacak bir element bul ve çift tıkla.
     * 5. Çift tıklama sonrasında açılacak olan ikinci alert penceresini kontrol et ve kapat.
     *
     * Uygulama Yapılacak Site: http://demo.guru99.com/test/simple_context_menu.html
     */
    @Test
    public void chainOfActionsTest() {
        // 1. Adım: Test yapılacak siteye git (Guru99 test sitesi)
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");

        MyFunction.wait(2);  // Sayfanın tamamen yüklenmesi için kısa bekleme süresi

        // 2. Adım: Sağ tıklanacak element bul (class="context-menu-one")
        WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));

        // 3. Adım: Çift tıklanacak buton bul
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

        // 4. Adım: Sağ tıklama işlemi gerçekleştir
        actions.moveToElement(rightClickButton)  // Elementin üzerine git
                .contextClick(rightClickButton)  // Sağ tıkla
                .perform();

        // 5. Adım: Sağ tıklama sonrası açılan context menüden "Copy" seçeneğini bul ve tıkla
        WebElement copyOption = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
        copyOption.click();

        // 6. Adım: Sağ tıklama sonrası açılan alert penceresini kontrol et ve kapat
        String alertMessage = driver.switchTo().alert().getText();  // Alert içeriğini al
        System.out.println("Sağ tıklama sonrası açılan alert mesajı: " + alertMessage);  // Konsola yazdır
        driver.switchTo().alert().accept();  // Alert penceresini kapat

        // 7. Adım: Çift tıklama işlemi yap
        actions.moveToElement(doubleClickButton)
                .doubleClick(doubleClickButton)  // Çift tıklama aksiyonu
                .perform();

        // 8. Adım: Çift tıklama sonrası açılan alert penceresini kontrol et
        String doubleClickAlertMessage = driver.switchTo().alert().getText();  // Alert içeriğini al
        String expectedDoubleClickMessage = "You double clicked me.. Thank You..";  // Beklenen mesaj
        assert doubleClickAlertMessage.equals(expectedDoubleClickMessage) : "Çift tıklama sonrası mesaj hatalı!";

        // 9. Adım: Çift tıklama sonrası açılan alert penceresini kapat
        driver.switchTo().alert().accept();  // Alert penceresini kapat

        waitAndClose();  // Test tamamlandıktan sonra tarayıcıyı kapat
    }

    /**
     * Fare Aksiyonları: Sağ tıklama (Right Click) ve Alert ile etkileşim
     */
    @Test
    public void rightClickTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        MyFunction.wait(2);
        WebElement elementToRightClick = driver.findElement(By.id("hot-spot"));
        actions.contextClick(elementToRightClick).perform();  // Sağ tıklama işlemi

        MyFunction.wait(2);

        // Açılan alert penceresini handle etme
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert içeriği: " + alert.getText());
        alert.accept(); // Alert penceresini kapatma

        MyFunction.wait(2);
        waitAndClose();
    }
}
