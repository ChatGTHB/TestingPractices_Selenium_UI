package _12_Exercises._05_DragAndDrop_28_02_2023.solution02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.BaseDriver;
import utility.MyFunction;

import java.util.List;

/*
Q1-
    http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
    Buradaki ülke ve şehirleri findElements ile topluca bularak
    bir döngü ile bütün şehirleri doğru ülkere dağıtınız.
*/
public class Q1 extends BaseDriver {

    public static void main(String[] args) {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        //driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        List<WebElement> cities = driver.findElements(By.cssSelector("#answerDiv > .dragDropSmallBox"));

        for (WebElement city : cities) {
            String num = city.getAttribute("id");
            num = num.substring(1);

            String cssSelector = "#questionDiv > .dragDropSmallBox[id='q" + num + "']";
            WebElement targetBox = driver.findElement(By.cssSelector(cssSelector));

            actions.clickAndHold(city).perform();
            MyFunction.wait(1);
            actions.moveToElement(targetBox).release().perform();
        }

       waitAndClose();
    }
}
