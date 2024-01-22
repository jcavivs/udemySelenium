package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment {

    public static void main(String[] args) throws InterruptedException {
       ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        List<WebElement> czk = driver.findElements(By.cssSelector("input[type='checkbox']"));

System.out.println("Size of checkboxes present in page = "+czk.size());
        driver.quit();
        
    }

    public static void pause() throws InterruptedException{
        Thread.sleep(1500);
    }
    
    
}
