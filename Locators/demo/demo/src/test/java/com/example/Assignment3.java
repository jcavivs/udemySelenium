package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {
        
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.cssSelector("input#usertype[value*='user']")).click();

        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        alert.click();
    
        WebElement roles = driver.findElement(By.cssSelector("select.form-control"));
        
        Select myRole = new Select(roles);
        myRole.selectByValue("consult");
        
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("input[type$='checkbox']")).click();
       
        Assert.assertTrue(driver.findElement(By.cssSelector("input[type$='checkbox']")).isSelected());
       
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.titleIs("ProtoCommerce"));

        List<WebElement> buttons = driver.findElements(By.cssSelector("button[class*='btn-info']"));

            int j = 0;
            for(int i=0; i<buttons.size(); i++){
                driver.findElements(By.cssSelector("button[class*='btn-info']")).get(i).click();
               
                if(j==buttons.size())
                {
                    break;
                }

            }
        
                if(driver.findElement(By.className("navbar-toggler")).isDisplayed()){
                    driver.findElement(By.className("navbar-toggler")).click();
                    driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
                }
                else{
                    driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
                }

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.table-hover")));
        
        driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
    
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'ProtoCommerce Home')]")));

        driver.findElement(By.id("country")).sendKeys("Philippines");

        driver.findElement(By.cssSelector("input[value$='Purchase']")).click();

        driver.quit();

    }   
        
}

    

