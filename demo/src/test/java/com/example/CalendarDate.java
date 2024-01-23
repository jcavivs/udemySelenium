package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDate {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

        List<WebElement> dates = driver.findElements(By.cssSelector(".ui-state-default"));

        int count = driver.findElements(By.cssSelector(".ui-state-default")).size();

        while(!driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-title']")).getText().contains("September 2024")){
            driver.findElement(By.cssSelector("a.ui-datepicker-next.ui-corner-all")).click();
        }

        for(int i=0;i<count;i++){
        String text = driver.findElements(By.className("ui-state-default")).get(i).getText();
        
        if(text.equalsIgnoreCase("30")){
        driver.findElements(By.className("ui-state-default")).get(i).click();
                
                
        String mm = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
        String dd = driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText();

        System.out.println(mm +" " +text+" "+ dd);

        break;
                
                
            }
                
        }
    }
    
}
