package runnerTest.webPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends ElementUtil {


    By todayClick = By.xpath("//a[@data-day='0']");
    By temperature = By.xpath("(//div[@class='temps'])[2]//span//span");
    By lowTemp = By.xpath("//a[@data-day='" + "0']//span[@class='minTemp']");
    By highTemp = By.xpath("//span[@class='high-temp-text']");
    By maxTemp = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");


    public void temperature() {
        WebElement element = BasePage.get().findElement(todayClick);
        JavaScriptUtil.scrollIntoView(element, BasePage.get());
        WebDriverWait wait = new WebDriverWait(BasePage.get(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(todayClick));
        BasePage.get().findElement(todayClick).click();


//		System.out.println(getTempList());
//		System.out.println(getMinTemp());
//		System.out.println(getMaxTemp());

    }

    static ArrayList < Integer > tempListInt = new ArrayList < Integer >();

    public ArrayList < Integer > getTempList() {
//		WebElement temperature= driver.findElement(By.xpath("(//div[@class='temps'])[2]//span//span"));

        WebDriverWait wait = new WebDriverWait(BasePage.get(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(temperature));
        List < WebElement > tempList = BasePage.get().findElements(temperature);
        for (int i = 0; i < tempList.size(); i++) {
            String tempText = tempList.get(i).getText().substring(0, 2);
            tempListInt.add(Integer.parseInt(tempText));

        }


        return tempListInt;
    }

    public int minTemp() {
        Collections.sort(tempListInt);
        return tempListInt.get(0);


    }

    public int maxTemp() {
        Collections.sort(tempListInt);
        return tempListInt.get(11);

    }

    public int verifyMin() {
        WebElement lowtemp = getElement(lowTemp);
        String lowTempStr = lowtemp.getText().substring(0, 2);

        return Integer.parseInt(lowTempStr);

    }

    public int verifyMax() {
        WebElement hightemp = BasePage.get().findElement(highTemp);
        String highTempStr = hightemp.getText().substring(0, 2);

        return Integer.parseInt(highTempStr);


    }


}