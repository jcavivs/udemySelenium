package com.example;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Assignment4 {

    public static void main(String[] args) {
        
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        
        driver.findElement(By.xpath("//li/a[contains(.,'Multiple Windows')]")).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='example'] /h3")).getText());
        
        driver.findElement(By.xpath("//div[@class='example'] /a")).click();
        
            Set<String> windows = driver.getWindowHandles();

        Iterator<String> iterate = windows.iterator();

        //  IM USING SUB CHILD BECAUSE IM HAVING PROBLEM THERE IS data; tab opens as parent every time I run my code
        
        String parentId = iterate.next();
        String childID = iterate.next();
        String secondChild = iterate.next();
  
        driver.switchTo().window(secondChild);
       
        System.out.println(driver.findElement(By.xpath("//div[@class='example'] /h3")).getText());

    }
    
}
