package _12_RobotClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

public class FileUploadWithRobotClass extends BaseDriver {

    /**
     Task:
     Robot Class ile Dosya Upload ve Doğrulama

     1)- Bilgisayarınızın masaüstünde içi herhangi bir şekilde dolu olan bir Word ya da text belgesi oluşturun.
     2)- https://dosya.org/ sitesine gidin.
     3)- Masaüstünüzde oluşturduğunuz Word ya da text belgesini Robot Class kullanarak upload edin.
     4)- Belgenin başarıyla upload edildiğini doğrulayın.
     5)- Upload edilen belgenizin download URL’sini Robot Class kullanarak yeni bir sekmede açın.
     6)- Açılan sekmenin belgenize ait olduğunu belge adı ile doğrulayın.
     */

    @Test
    public void uploadFileWithRobotClass() throws AWTException {

        // 1. Adım: https://dosya.org/ sitesine git
        driver.get("https://dosya.org/");

        // 2. Adım: Robot Class tanımlama
        Robot robot = new Robot();

        // 3. Adım: Tab tuşlarıyla gezinme işlemi (Robot Class ile site içinde hareket)
        // Bu adımda site içinde form alanına gitmek için Tab tuşlarını simüle ediyoruz.
        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_TAB);  // Tab tuşuna bas
            robot.keyRelease(KeyEvent.VK_TAB);  // Tab tuşunu bırak
            MyFunction.wait(1);  // Kontrol amaçlı kısa bekleme, klavye olayları görsel olarak izlenebilsin diye eklendi
        }

        // 4. Adım: Enter tuşuna basarak dosya seçme ekranına geçiş yap
        MyFunction.wait(2);  // Kısa bekleme, ekranın yüklenmesini bekliyoruz
        robot.keyPress(KeyEvent.VK_ENTER);  // Enter tuşuna bas
        robot.keyRelease(KeyEvent.VK_ENTER);  // Enter tuşunu bırak

        // 5. Adım: İçerideki bir öğeye tıklayın
        MyFunction.wait(1);  // Kısa bekleme, kontrol amaçlı
        driver.findElement(By.className("internal")).click();  // Dosya seçme alanına tıklama işlemi

        // 6. Adım: Dosya yolunu panoya kopyalama
        // Masaüstünüzdeki dosyanın tam yolunu panoya kopyalıyoruz.
        StringSelection filePath = new StringSelection("C:\\Users\\cihat\\Desktop\\RobotClass.docx");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        // 7. Adım: CTRL + V ile dosya yolunu yapıştırma (Robot Class ile)
        MyFunction.wait(1);  // Kısa bekleme, kontrol amaçlı
        robot.keyPress(KeyEvent.VK_CONTROL);  // CTRL tuşuna bas
        robot.keyPress(KeyEvent.VK_V);  // V tuşuna bas (Yapıştırma işlemi)
        robot.keyRelease(KeyEvent.VK_CONTROL);  // CTRL tuşunu bırak
        robot.keyRelease(KeyEvent.VK_V);  // V tuşunu bırak

        // 8. Adım: Klavye ile sekmeler arasında gezinme (Tab tuşu)
        // Dosya yükleme formunda, Tab tuşu ile diğer alanlara geçiyoruz.
        MyFunction.wait(1);  // Kısa bekleme, kontrol amaçlı
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_TAB);  // Tab tuşuna bas
            robot.keyRelease(KeyEvent.VK_TAB);  // Tab tuşunu bırak
            MyFunction.wait(1);  // Kontrol amaçlı kısa bekleme
        }

        // 9. Adım: Enter tuşuna basarak dosya yükleme işlemini başlatma
        MyFunction.wait(2);  // Kısa bekleme, ekranın tamamen yüklenmesini bekliyoruz
        robot.keyPress(KeyEvent.VK_ENTER);  // Enter tuşuna bas
        robot.keyRelease(KeyEvent.VK_ENTER);  // Enter tuşunu bırak

        // 10. Adım: Tab tuşu ile sayfada gezinme (Yükleme alanına gitme)
        // Bu adımda dosyanın yüklendiği formdan, indirme linkine ulaşmak için Tab tuşunu kullanıyoruz.
        MyFunction.wait(1);  // Kısa bekleme, kontrol amaçlı
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_TAB);  // Tab tuşuna bas
            robot.keyRelease(KeyEvent.VK_TAB);  // Tab tuşunu bırak
            MyFunction.wait(1);  // Kontrol amaçlı kısa bekleme
        }

        // 11. Adım: Enter tuşuna basarak dosya yükleme işlemini tamamla
        MyFunction.wait(2);  // Kısa bekleme, dosyanın yüklenmesini bekliyoruz
        robot.keyPress(KeyEvent.VK_ENTER);  // Enter tuşuna bas
        robot.keyRelease(KeyEvent.VK_ENTER);  // Enter tuşunu bırak

        // 12. Adım: Dosyanın yüklenmesini doğrulama
        // Dosyanın tamamen yüklendiğini doğrulamak için bir bekleme süresi ekliyoruz.
        MyFunction.wait(10);  // Upload işleminin bitmesini bekliyoruz (Kontrol amaçlı uzun bekleme)

        // 13. Adım: Upload işleminin başarılı olduğunu doğrulama
        // Dosyanın başarılı bir şekilde yüklendiğinden emin olmak için bir kontrol yapıyoruz.
        Assert.assertTrue("Upload işlemi başarısız.",
                driver.findElement(By.xpath("(//div[@class='baseText'])[3]"))
                        .getText()
                        .contains("uploads completed"));

        // 14. Adım: Yüklenen dosyanın indirme linkini alma
        WebElement downloadLink = driver.findElement(By.xpath("//td[@class='url urlOff']"));
        String downloadLinkStr = downloadLink.getText();

        // 15. Adım: Yeni sekme açma ve dosya indirme linkine gitme (Robot Class ile)
        MyFunction.wait(2);  // Kısa bekleme, kontrol amaçlı
        robot.keyPress(KeyEvent.VK_CONTROL);  // CTRL tuşuna bas
        robot.keyPress(KeyEvent.VK_T);  // T tuşuna bas (Yeni sekme aç)
        robot.keyRelease(KeyEvent.VK_CONTROL);  // CTRL tuşunu bırak
        robot.keyRelease(KeyEvent.VK_T);  // T tuşunu bırak

        // 16. Adım: Yeni sekmeye geçiş yap
        Set<String> windowsIDS = driver.getWindowHandles();  // Açık olan tüm pencerelerin ID'lerini alıyoruz
        Iterator<String> iterator = windowsIDS.iterator();  // ID'ler arasında gezinmek için iterator kullanıyoruz
        String firstTab = iterator.next();  // İlk sekme
        String secondTab = iterator.next();  // İkinci sekme

        MyFunction.wait(1);  // Kısa bekleme, geçiş yapmadan önce
        driver.switchTo().window(secondTab);  // Yeni sekmeye geçiş yap
        driver.get(downloadLinkStr);  // İndirme linkine git

        // 17. Adım: Dosyanın doğru şekilde indirildiğini doğrulama
        // İndirme sayfasında dosyanın adını kontrol ediyoruz.
        MyFunction.wait(1);  // Kısa bekleme, kontrol amaçlı
        WebElement fileName = driver.findElement(By.xpath("(//td[@class='responsiveInfoTable'])[1]"));
        String fileNameStr = "RobotClass.docx";

        MyFunction.wait(5);  // Kontrol amaçlı kısa bekleme
        Assert.assertTrue("İndirilen dosya adı yanlış.", fileName.getText().contains(fileNameStr));

        // 18. Adım: Testi sonlandır ve tarayıcıyı kapat
        waitAndClose();  // 3 saniye bekleme ve tarayıcıyı kapatma işlemi
    }
}
