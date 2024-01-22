package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssertTrue {
    public static void main(String[] args) throws InterruptedException {
        
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='ctl00_mainContent_chk_friendsandfamily']")).isSelected());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        System.out.println("Before Clicking Drowndown Button: "+driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1500);

            for(int i=1 ; i<5 ; i++){
                driver.findElement(By.id("hrefIncAdt")).click();
            }
            for(int j=0; j<2;j++){
                driver.findElement(By.id("hrefIncChd")).click();
            }
            for (int k=0;k<1;k++){
                driver.findElement(By.id("hrefIncInf")).click();
            }
        
        driver.findElement(By.id("btnclosepaxoption")).click();

        System.out.println("After Clicking Drowndown Button: "+driver.findElement(By.id("divpaxinfo")).getText());

        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult, 2 Child, 1 Infant");

        driver.quit();
    }
    
}
