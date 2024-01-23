package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) throws InterruptedException {
        
    ChromeDriver driver = new ChromeDriver();

    driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    driver.findElement(By.id("name")).sendKeys("Jaycee");
    pause();
    driver.findElement(By.cssSelector("input[value*='Alert']")).click();
    System.out.println(driver.switchTo().alert().getText());
    pause();
    driver.switchTo().alert().accept();
    driver.findElement(By.id("name")).sendKeys("Clarence");
    pause();
    driver.findElement(By.xpath("//fieldset/input[@value='Confirm']")).click();
    System.out.println(driver.switchTo().alert().getText());
    pause();
    
    driver.quit();
    }

    private static void pause() throws InterruptedException{
        Thread.sleep(1500);
    }
}
