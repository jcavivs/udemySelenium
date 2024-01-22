package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

    public static void main(String[] args) {
        
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Nested Frames")).click();

        WebElement top = driver.findElement(By.cssSelector("frame[src*='/frame_top']"));
        driver.switchTo().frame(top);
        
        List frameleList = driver.findElements(By.tagName("frame"));
        
            for(int i = 0; i<frameleList.size();i++){
            driver.switchTo().frame(i);
            System.out.println(driver.findElement(By.tagName("body")).getText());
            driver.switchTo().parentFrame();
            }
        driver.switchTo().defaultContent();

        WebElement bottom = driver.findElement(By.cssSelector("frame[name*='frame-bottom']"));
        driver.switchTo().frame(bottom);
        System.out.println(driver.findElement(By.tagName("body")).getText());
      
        driver.quit();
           
        }
}
