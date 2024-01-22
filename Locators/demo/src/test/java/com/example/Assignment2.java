package com.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
    
    public static void main(String[] args) {
        
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.xpath("//form/div/input[contains(@name,'name')]")).sendKeys("John Clarence Vivo");
        driver.findElement(By.cssSelector("input[name*='email']")).sendKeys("jcavivo@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("rmcxaqwt");
        driver.findElement(By.id("exampleCheck1")).click();

        
        WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));  
        Select selecGender = new Select(gender);

        selecGender.selectByVisibleText("Male");

        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("04-06-1996");

        driver.findElement(By.cssSelector("input.btn.btn-success")).click();

        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

    }
}
