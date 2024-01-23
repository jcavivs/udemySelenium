package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        String name = "Clarence";
        String password = getPassword(driver);
        

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
        // driver.findElement(By.linkText("Forgot your password?")).click();;
        // driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Clarence");;
        // driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("John");
        // driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("09123456789");
        // driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        // driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john.vivo@gmail.com");
        // Thread.sleep(1000);
        // driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        // Thread.sleep(1500);
        // System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
        // driver.findElement(By.className("go-to-login-btn")).click();
        // Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*=pass]")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.submit.signInBtn")).click();;
        
        Thread.sleep(1500);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in."); 
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
        // driver.findElement(By.xpath("//button[contains(@class,logout)]")).click();
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();;
        driver.quit();
        
    }

    public static String getPassword(ChromeDriver driver) throws InterruptedException{
        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();;
        // driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Clarence");;
        // driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("John");
        // driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("09123456789");
        // driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
        // driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john.vivo@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

        
        Thread.sleep(1500);
        String trimit = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        
        String[] splitname = trimit.split("'");
        String password = splitname[1].split("'")[0];

        driver.findElement(By.className("go-to-login-btn")).click();
        // Thread.sleep(1000);
        

        return password;
    }
}
    



