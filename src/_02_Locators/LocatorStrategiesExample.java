package _02_Locators;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;


public class LocatorStrategiesExample extends BaseDriver {

    @Test
    public void testRegister() {
        // Siteye gidiyoruz
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // 1. By.linkText() - Register butonunu linkText ile buluyoruz
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        // 2. By.name() - First Name alanını name attribute'u ile buluyoruz
        WebElement firstNameInput = driver.findElement(By.name("customer.firstName"));
        firstNameInput.sendKeys("Ahmet");

        // Diğer input alanlarını doldurma işlemi
        WebElement lastNameInput = driver.findElement(By.id("customer.lastName"));
        lastNameInput.sendKeys("Yılmaz");

        WebElement addressInput = driver.findElement(By.id("customer.address.street"));
        addressInput.sendKeys("123 Ana Cadde");

        WebElement cityInput = driver.findElement(By.name("customer.address.city"));
        cityInput.sendKeys("İstanbul");

        WebElement stateInput = driver.findElement(By.id("customer.address.state"));
        stateInput.sendKeys("İstanbul");

        WebElement zipCodeInput = driver.findElement(By.id("customer.address.zipCode"));
        zipCodeInput.sendKeys("34000");

        WebElement phoneNumberInput = driver.findElement(By.id("customer.phoneNumber"));
        phoneNumberInput.sendKeys("5551234567");

        WebElement ssnInput = driver.findElement(By.id("customer.ssn"));
        ssnInput.sendKeys("123456789");

        WebElement usernameInput = driver.findElement(By.id("customer.username"));
        usernameInput.sendKeys("kullaniciadi"+(int)(Math.random()*10000));

        WebElement passwordInput = driver.findElement(By.id("customer.password"));
        passwordInput.sendKeys("Sifre123");

        WebElement confirmPasswordInput = driver.findElement(By.id("repeatedPassword"));
        confirmPasswordInput.sendKeys("Sifre123");

        // 13. Register butonuna tıklıyoruz
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        registerButton.click();

        MyFunction.wait(2);

        // Başarılı bir şekilde kaydolduğunuzu doğruluyoruz
        WebElement successMessage = driver.findElement(By.className("title"));

        // Mesajı kontrol etmeden önce konsola yazdırıyoruz
        String actualMessage = successMessage.getText();
        System.out.println("Mesaj: " + actualMessage);

        // JUnit ile assertion yapıyoruz
        Assert.assertTrue("Kayıt başarılı değil! Beklenen mesaj bulunamadı.", actualMessage.contains("Welcome"));

        waitAndClose();
    }
}
