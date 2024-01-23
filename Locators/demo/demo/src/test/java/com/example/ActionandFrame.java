package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionandFrame {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        Actions myAction = new Actions(driver);
        WebElement myelement = driver.findElement(By.id("email"));

        myAction.moveToElement(myelement).click().keyDown(Keys.SHIFT).sendKeys("automation").build().perform();
        myAction.moveToElement(myelement).contextClick().build().perform();


    }
    
}
