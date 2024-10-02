package _12_RobotClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.BaseDriver;
import utility.MyFunction;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class GoogleSearchWithRobotClass extends BaseDriver {

    /**
     * Task:

     1. Google ana sayfasına gidin: https://www.google.com.
     2. "Tümünü reddet" butonu varsa, çerez uyarısını kapatın.
     3. Google arama kutusuna fare ile tıklayarak odaklanın.
     4. Robot Class kullanarak "Selenium Robot Class" metnini panoya kopyalayın ve arama kutusuna yapıştırın.
     5. Arama işlemini başlatmak için "Enter" tuşuna basın.
     6. Google arama sonuçlarında, sayfanın tam olarak yüklenmesini bekleyin (ilk sonuç başlığının görünmesini bekleyin).
     7. Fareyi ekranın sağ üst köşesine hareket ettirin ve sol tıklama yapın.
        Not: Koordinatlar ekranın çözünürlüğüne göre dinamik olarak ayarlanmış olmalıdır.
     8. Fareyi ekranın sol alt köşesine hareket ettirin ve sağ tıklama yapın.
        Not: Bu hareket de dinamik olarak ekran çözünürlüğüne göre ayarlanmış olmalıdır.
     9. Tüm işlemler tamamlandıktan sonra tarayıcıyı kapatın.
     */

    @Test
    public void robotClassTest() throws AWTException {

        // 1. Adım: Google ana sayfasına git
        driver.get("https://www.google.com");

        // 2. Adım: "Tümünü reddet" butonu varsa tıklayın (çerez uyarısı)
        List<WebElement> rejectAll = driver.findElements(By.xpath("//button[@id='W0wltc']/div"));
        if (!rejectAll.isEmpty()) {
            rejectAll.get(0).click();  // "Tümünü reddet" butonuna tıkla
        }

        // 3. Adım: Arama kutusunu bul ve ona tıklayarak odaklan
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();  // Arama kutusuna tıklayarak odaklanıyoruz

        // 4. Adım: Robot Class tanımla
        Robot robot = new Robot();

        // Ekran çözünürlüğünü alalım (Fare hareketleri için dinamik kullanacağız)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // 5. Adım: "Selenium Robot Class" ifadesini panoya kopyalayın
        String searchTerm = "Selenium Robot Class";
        StringSelection stringSelection = new StringSelection(searchTerm);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        MyFunction.wait(3); // Hareketi gözlemlemek için kısa bekleme

        // 6. Adım: Google arama kutusuna CTRL + V ile yapıştırın
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        MyFunction.wait(3); // Hareketi gözlemlemek için kısa bekleme

        // 7. Adım: Enter tuşuna basarak arama yapın
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // 8. Adım: Explicit Wait kullanarak ilk arama başlığının gelmesini bekleyin
        WebElement firstResultHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h3")));

        // 9. Adım: Fareyi sağ üst köşeye hareket ettir (dinamik çözünürlük ile)
        // Ekranın sağ üst köşesi: x = ekran genişliği, y = 50 (biraz aşağıda olsun)
        robot.mouseMove(screenWidth - 10, 50);  // Sağ üst köşeye yakın bir noktaya hareket ettir

        MyFunction.wait(3); // Hareketi gözlemlemek için kısa bekleme

        // 10. Adım: Fare ile sol tıklama yap
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

        MyFunction.wait(3); // Hareketi gözlemlemek için kısa bekleme

        // 11. Adım: İkinci fare hareketi: Sol alta yakın bir yere götür (x: 10, y: ekranın yüksekliği - 50)
        robot.mouseMove(10, screenHeight - 50);  // Sol alt köşeye yakın bir noktaya hareket ettir

        MyFunction.wait(3); // Sağ tıklamadan önce bekleme

        // 12. Adım: Sağ tıklama (fare sağ tuşunu kullanarak)
        robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);  // Sağ tıklama
        robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);  // Sağ tıklamayı bırak

        // 13. Adım: Testi sonlandır ve tarayıcıyı kapat
        waitAndClose();
    }
}
