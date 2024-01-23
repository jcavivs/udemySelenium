package com.example;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

 public static void main(String[] args) throws IOException {
        
        ChromeDriver driver = new ChromeDriver();
        driver.manage().deleteCookieNamed("");
        driver.manage().window().maximize();
        
        driver.get("https://www.facebook.com");
        captureThis(driver, "C:\\Users\\Admin\\Documents\\Udemy\\Locators\\demo\\Screenshots/printScreen.png");

        WebElement scrElement = driver.findElement(By.id("email"));

        captureElement(scrElement, "C:\\Users\\Admin\\Documents\\Udemy\\Locators\\demo\\Screenshots/scrShot.png");
    
        driver.quit();
    }

    public static void captureThis(ChromeDriver driver, String filename) throws IOException{
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(filename));

    }

    public static void captureElement(WebElement element, String filename) throws IOException{
        File screenShot = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(filename));
    }
    
}