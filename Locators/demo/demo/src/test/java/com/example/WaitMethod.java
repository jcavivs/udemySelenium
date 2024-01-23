package com.example;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitMethod {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("[id='start'] button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(10))
                    .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver,WebElement>() {

            
            public WebElement apply(WebDriver driver) {

                if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                }
                else{
                    return null;
                }
            }
        });

        System.out.println(element.getText());
    }
    
}
