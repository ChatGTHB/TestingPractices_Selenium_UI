package _12_Exercises._05_DragAndDrop_28_02_2023.solution02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

/*
Q1-
    http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html
    Buradaki bütün öğrencileri bütün kutucukları doldurana kadar atınız.
*/
public class Q2 extends BaseDriver {
    public static void main(String[] args) {

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        //driver.manage().window().maximize();

        List<WebElement> students = driver.findElements(By.cssSelector("#allItems>li"));
        List<WebElement> teams = driver.findElements(By.cssSelector("#dhtmlgoodies_mainContainer>div ul"));

        Actions actions = new Actions(driver);

        for (WebElement t : teams) {
            String strHeight = t.getCssValue("height");
            int height = Integer.parseInt(strHeight.replaceAll("[^0-9]", ""));

            // Aşşağıdaki 29( Örnek bir grubunun height/4'üne eşittir
            // bu ekran çözünürlüğünüze göre değişebilir kontrol ediniz)
            // Daha fonksiyonel çözümleride sizlerden bekliyoruz.

            while (height >= 29 && students.size() > 0) {
                actions.clickAndHold(students.get(0)).perform();
                MyFunction.wait(1);
                actions.moveToElement(t).release().perform();
                students.remove(students.get(0));
                height = height - 29;
            }
        }

        waitAndClose();
    }
}
