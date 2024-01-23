package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {
        
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Start of Scrolling using JS
        JavascriptExecutor jscript = (JavascriptExecutor) driver;

        jscript.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1500);
        jscript.executeScript("document.querySelector('.tableFixHead').scrollTop=50");

        // end of JS

        //Start of Manipulating Table
        List<WebElement> values =driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for(int i=0; i<values.size();i++){
            // System.out.println(Integer.parseInt(values.get(i).getText()));
            int x = Integer.parseInt(values.get(i).getText());

            sum = sum + x;

        }

        System.out.println(sum);

        String totSum = driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim();
        int i = Integer.parseInt(totSum);

        Assert.assertEquals(i, sum);
        //End of manipulating Table
        
    }
    
}
