package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {
    public static void main(String[] args) {
        
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
       
        Actions myAction = new Actions(driver);
        WebElement myItem = driver.findElement(By.id("draggable"));
        WebElement dropOff = driver.findElement(By.id("droppable"));

        // myAction.moveToElement(myItem).clickAndHold().moveByOffset(160, 15).build().perform();
        myAction.dragAndDrop(myItem, dropOff).build().perform();

        driver.quit();
    }
    
}
