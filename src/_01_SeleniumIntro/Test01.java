package _01_SeleniumIntro;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.BaseDriver;
import utility.MyFunction;

public class Test01 extends BaseDriver {

    @Test
    public void registerTest(){
        driver.get("http://demo.nopcommerce.com/");

        MyFunction.wait(3);
        WebElement checkbox= driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();

        MyFunction.wait(2);
        WebElement registerLink= driver.findElement(By.linkText("Register"));
        registerLink.click();

        MyFunction.wait(2);
        WebElement genderMale= driver.findElement(By.id("gender-male"));
        genderMale.click();

        MyFunction.wait(2);
        WebElement firstName= driver.findElement(By.cssSelector("[name='FirstName']"));
        firstName.sendKeys("First Name");

        MyFunction.wait(2);
        WebElement lastName = driver.findElement(By.xpath("//input[@data-val-required='Last name is required.']"));
        lastName.sendKeys("Last Name");

        MyFunction.wait(2);
        WebElement eMail= driver.findElement(By.xpath("(//input[@type='email'])[1]"));
        eMail.sendKeys("testing"+((int)(Math.random()*10000))+"@testing.com");

        MyFunction.wait(2);
        WebElement company= driver.findElement(By.id("Company"));
        company.sendKeys("Company");

        MyFunction.wait(2);
        WebElement password= driver.findElement(By.cssSelector("[name='Password']"));
        password.sendKeys("123456");

        MyFunction.wait(2);
        WebElement confirmPassword= driver.findElement(By.cssSelector("[name='ConfirmPassword']"));
        confirmPassword.sendKeys("123456");

        MyFunction.wait(2);
        WebElement registerButton= driver.findElement(By.cssSelector("[name='register-button']"));
        registerButton.click();
    }
}
