package _09_IFrames;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;

import java.util.List;

public class IframeTextAreaTest extends BaseDriver {

    /**
     Task:

     - "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_textarea" adresine gidin.
     - Çerez onayı varsa kapatın.
     - Sayfadaki iframe'e geçiş yapın.
     - Iframe içindeki textarea'nın mevcut metnini temizleyip, yeni metin yazın: "Bu metin Selenium ile değiştirilmiştir!"
     - Iframe'den çıkın ve ana sayfaya dönün.
     - Birkaç saniye bekleyip sayfayı kapatın.
     */
    @Test
    public void iframeTextAreaTest() {
        // 1. İlgili sayfayı aç
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_textarea");

        // 2. Çerez onay butonunu kontrol et ve varsa tıkla
        List<WebElement> acceptCookiesButton = driver.findElements(By.id("accept-choices")); // Çerez butonunu bul
        if (!acceptCookiesButton.isEmpty()) {  // Eğer liste boş değilse buton var demektir
            acceptCookiesButton.get(0).click();  // Butona tıkla
        }

        // 3. Sayfadaki iframe'e geçiş yap (W3Schools'un demo iframe'i)
        WebElement iframe = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe);  // WebElement ile iframe'e geçiş

        // Alternatif geçiş yöntemleri:
        // driver.switchTo().frame(0);  // Sayfada sadece bir iframe varsa, index ile de geçiş yapılabilir.
        // driver.switchTo().frame("iframeResult");  // Name veya ID ile de geçiş yapılabilir.

        // 4. Iframe içindeki metin kutusunu (textarea) bul ve mevcut metni temizle
        WebElement textArea = driver.findElement(By.xpath("//textarea"));
        textArea.clear();  // Textarea'nın içeriğini temizle

        // 5. Textarea'ya yeni metin yaz
        textArea.sendKeys("Bu metin Selenium ile değiştirilmiştir!");

        // 6. Iframe'den çıkmak için parentFrame() veya defaultContent() kullanın
        driver.switchTo().parentFrame();  // Bir üst seviyeye geç

        // Alternatif: Tüm iframelerden çıkıp doğrudan ana sayfaya dönmek için:
        // driver.switchTo().defaultContent();

        // 7. Birkaç saniye bekleyip sayfayı kapat
        waitAndClose();
    }
}
