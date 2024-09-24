package _06_ActionsAndAlert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

public class ActionChainsClass extends BaseDriver {

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
     * Test Senaryosu: Sürükle ve Bırak (Drag and Drop) Aksiyonları
     *
     * Görevler:
     * 1. Bir element bulun ve bu elementi sürükleyip başka bir elementin üzerine bırakın.
     * 2. Sürükle-bırak işlemi başarıyla tamamlandığında geri bildirim olarak "Dropped!" mesajını kontrol edin.
     *
     * Uygulama Yapılacak Site: https://jqueryui.com/droppable/
     */
    @Test
    public void buildAndPerformTest() {
        // 1. Adım: Test yapılacak siteye git (jQuery UI demo sitesi)
        driver.get("https://jqueryui.com/droppable/");

        // 2. Adım: Sayfada iFrame bulunuyor, iFrame'e geçiş yap
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

        // 3. Adım: Sürükleyeceğimiz element (id="draggable")
        WebElement sourceElement = driver.findElement(By.id("draggable"));

        // 4. Adım: Bırakacağımız hedef element (id="droppable")
        WebElement targetElement = driver.findElement(By.id("droppable"));

        MyFunction.wait(2);  // Sayfanın tamamen yüklenmesi için bekleme süresi

        // 5. Adım: Sürükle ve bırak işlemi gerçekleştirilir
        actions.clickAndHold(sourceElement)  // Elementi tıklayıp tut
                .moveToElement(targetElement)  // Hedefe sürükle
                .release(targetElement)        // Hedefin üzerine bırak
                .build()  // Aksiyon zincirini inşa et
                .perform();  // Zinciri gerçekleştir

        // 6. Adım: Sürükle-bırak işlemi sonrası "Dropped!" mesajı doğru şekilde görünüyor mu, kontrol et
        String dropMessage = targetElement.getText();  // Hedef elementin içindeki metni al
        String expectedDropMessage = "Dropped!";  // Beklenen geri bildirim mesajı
        assert dropMessage.equals(expectedDropMessage) : "Sürükleme işlemi başarısız!";

        waitAndClose();  // Test tamamlandıktan sonra tarayıcıyı kapat
    }
}
