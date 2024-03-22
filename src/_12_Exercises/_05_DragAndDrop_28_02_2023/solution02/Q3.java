package _12_Exercises._05_DragAndDrop_28_02_2023.solution02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;

import java.util.List;

/*
Q1-
    --Challenge sorusu--
    http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html
    Buradaki bütün şehirleri bütün ülkere doğru şekilde topluca dağıtınız.
*/
public class Q3 extends BaseDriver {
    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> cities = driver.findElements(By.cssSelector("#allItems > *"));
        List<WebElement> countries = driver.findElements(By.cssSelector("#dhtmlgoodies_mainContainer > div"));

        for (WebElement city : cities) {
            actions.moveToElement(city, -30, 0).perform();
            actions.clickAndHold().perform();
            //MyFunc.Bekle(1);
            Bekle(200);
            for (WebElement country : countries) {
                actions.moveToElement(country).perform();
                if (!country.getAttribute("class").equals("mouseover"))
                    continue;
                actions.release().perform();
                //MyFunc.Bekle(1);

                Bekle(200);
                try {
                    driver.switchTo().alert().accept();
                }catch (Exception e){
                    //System.out.println("Alert Yok");
                }
                if (!city.getAttribute("class").equals("correctAnswer")) {
                    actions.moveToElement(city, -30, 0).perform();
                    actions.clickAndHold().perform();
                    // MyFunc.Bekle(1);
                    Bekle(200);
                    continue;
                }
                break;
            }
        }

        waitAndClose();
    }

    public static void Bekle(double sn) {
        try {
            Thread.sleep((long) sn);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
