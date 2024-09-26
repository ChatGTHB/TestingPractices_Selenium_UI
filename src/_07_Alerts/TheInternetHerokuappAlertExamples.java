package _07_Alerts;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;


public class TheInternetHerokuappAlertExamples extends BaseDriver {


    @Test
    public void clickForJSAlertTest() {
        driver.get("https://the-internet.herokuapp.com/");

        WebElement jsAlert = driver.findElement(By.xpath("//*[text()='JavaScript Alerts']"));
        jsAlert.click();
        MyFunction.wait(3);
        WebElement alertButton1 = driver.findElement(By.xpath("(//button)[1]"));
        alertButton1.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Alert Mesajı : " + alertText);
        MyFunction.wait(3);
        alert.accept();

        waitAndClose();
    }

    @Test
    public void clickForJSConfirmTest() {
        driver.get("https://the-internet.herokuapp.com/");

        WebElement jsAlert = driver.findElement(By.xpath("//*[text()='JavaScript Alerts']"));
        jsAlert.click();
        MyFunction.wait(3);

        WebElement alertButton2 = driver.findElement(By.xpath("(//button)[2]"));
        alertButton2.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Mesajı : " + alertText);
        MyFunction.wait(3);

        //alert.accept();
        alert.dismiss();

        waitAndClose();
    }

    @Test
    public void clickForJSPromptTest() {
        driver.get("https://the-internet.herokuapp.com/");

        WebElement jsAlert = driver.findElement(By.xpath("//*[text()='JavaScript Alerts']"));
        jsAlert.click();
        MyFunction.wait(3);

        WebElement alertButton3 = driver.findElement(By.xpath("(//button)[3]"));
        alertButton3.click();

        Alert alert = driver.switchTo().alert();

        System.out.println("Alert Mesajı : " + alert.getText());

        MyFunction.wait(3);

        alert.sendKeys("Merhaba, Selenium");

        alert.accept();

        MyFunction.wait(3);

        System.out.println("Alert gönderilen mesaj: " + driver.findElement(By.id("result")).getText());

        waitAndClose();
    }

    /**
     * Fare Aksiyonları: Sağ tıklama (Right Click) ve Alert ile etkileşim
     */
    @Test
    public void rightClickTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        MyFunction.wait(2);
        WebElement elementToRightClick = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(elementToRightClick).perform();  // Sağ tıklama işlemi
        MyFunction.wait(2);

        // Açılan alert penceresini handle etme
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert içeriği: " + alert.getText());
        alert.accept(); // Alert penceresini kapatma

        waitAndClose();
    }
}
