package _06_ActionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;



public class ActionClass extends BaseDriver {

    @Test
    public void actionsMethods() {

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().setPosition(new Point(-1000, 0));
        driver.manage().window().maximize();

        Actions aksiyonDriver = new Actions(driver);
        //Mouse Hover (Fare Üzerine Gelme):
//        WebElement hover = driver.findElement(By.xpath("//*[text()='Hovers']"));
//        aksiyonDriver.click(hover).perform();
//
//        WebElement user1 = driver.findElement(By.xpath("(//*[@alt='User Avatar'])[1]"));
//        aksiyonDriver.moveToElement(user1).perform();
//        MyFunction.wait(3);
//
//        WebElement user2 = driver.findElement(By.xpath("(//*[@alt='User Avatar'])[2]"));
//        aksiyonDriver.moveToElement(user2).perform();
//        MyFunction.wait(3);
//
//        WebElement user3 = driver.findElement(By.xpath("(//*[@alt='User Avatar'])[3]"));
//        aksiyonDriver.moveToElement(user3).perform();
//        MyFunction.wait(3);

        //Right Click (Sağ Tıklama)

        WebElement contextMenu = driver.findElement(By.xpath("//*[text()='Context Menu']"));
        aksiyonDriver.click(contextMenu).perform();
        MyFunction.wait(3);

        WebElement rightClick = driver.findElement(By.id("hot-spot"));
        aksiyonDriver.contextClick(rightClick).build().perform();
        MyFunction.wait(3);

        driver.switchTo().alert().accept();

        waitAndClose();
    }
}
