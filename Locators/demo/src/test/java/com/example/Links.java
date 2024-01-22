package com.example;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Links {
    public static void main(String[] args) throws InterruptedException {


        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));    

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        Assert.assertEquals(27, driver.findElements(By.tagName("a")).size());

        WebElement footer = driver.findElement(By.id("gf-BIG"));

        System.out.println(footer.findElements(By.tagName("a")).size());

        Assert.assertEquals(20, footer.findElements(By.tagName("a")).size());

        WebElement firstColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(firstColumn.findElements(By.tagName("a")).size());

        Assert.assertEquals(5, firstColumn.findElements(By.tagName("a")).size());
        
        // List columnsCount = firstColumn.findElements(By.tagName("a")).size();

        for(int i=1; i<firstColumn.findElements(By.tagName("a")).size();i++){
            String clinkonLink = Keys.chord(Keys.CONTROL,Keys.ENTER);

            firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clinkonLink);
        
        }

        Thread.sleep(5000);
        Set<String> handles = driver.getWindowHandles();
        Iterator <String> it = handles.iterator();

        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }
    
}
