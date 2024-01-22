package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Calendar {
    public static void main(String[] args) throws InterruptedException {
       ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='PYG']")).click();
        Thread.sleep(1500); 


        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='JLR']")).click();;
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

            if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
                Assert.assertTrue(true);
                driver.quit();
            }
            else{
                Assert.assertTrue(false);
            }

    }
    
}
