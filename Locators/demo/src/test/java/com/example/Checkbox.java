package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkbox {
    public static void main(String[] args) throws InterruptedException {
        
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected());


        // Thread.sleep(3000);
        // driver.findElement(By.xpath("//div[@id='discount-checkbox']/div[contains(label,'Minor')]")).click();;
        // System.out.println(driver.findElement(By.xpath("//div[@id='discount-checkbox']/div[contains(label,'Minor')]")).isSelected();
        // // Assert.assertTrue(driver.findElement(By.xpath("//div[@id='discount-checkbox']/div[contains(label,'Minor')]")).isSelected());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

  
        
    }
     
}
 