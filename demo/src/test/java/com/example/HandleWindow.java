package com.example;

import java.util.Set;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindow {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        
  
        driver.findElement(By.cssSelector(".blinkingText")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(3000);
        
       
        Set<String> windows = driver.getWindowHandles();

        Iterator<String> iterate = windows.iterator();

        String parentId = iterate.next();
        String childID = iterate.next();
        String secondChild = iterate.next();

        driver.switchTo().window(parentId);
        driver.switchTo().window(childID);
        driver.switchTo().window(secondChild);
       

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

        driver.findElement(By.cssSelector(".im-para.red")).getText();

        String emailId= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
       
        driver.switchTo().window(childID);
        
        driver.findElement(By.id("username")).sendKeys(emailId);

        




        

        
    }

    
}
