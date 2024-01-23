package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.id("checkBoxOption3")).click();

        String label = driver.findElement(By.id("checkBoxOption3")).getAttribute("value");

        WebElement itemDropdown = driver.findElement(By.id("dropdown-class-example"));  
        Select mySelection = new Select(itemDropdown);

        mySelection.selectByValue(label);


        driver.findElement(By.cssSelector("input#name")).sendKeys(label);
        driver.findElement(By.id("alertbtn")).click();

        String alertInfo = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        Assert.assertTrue(alertInfo.contains(label));

        driver.quit();

    }
    
}
