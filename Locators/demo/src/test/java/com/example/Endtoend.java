package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Endtoend {
    
    public static void main(String[] args) throws InterruptedException {
        
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

        //  DYNAMIC DROPDOWN APPROACH
        // System.out.println(driver.findElement(By.cssSelector("div.slider.has-touch")).getAttribute("style"));
       
        if(driver.findElement(By.cssSelector("div.slider.has-touch")).getAttribute("style").contains("width: 400px;"))
        {
            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();
            driver.findElement(By.xpath("//option[@value='PYG']")).click();
            pause();
            driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1")).click();


            WebElement secondDestination = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1"))  ;  
            Select sdSelection = new Select(secondDestination);
            sdSelection.selectByValue("BKK");


            // driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1'] //option[@value='JLR']")).click();;
            pause();
            driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
            pause();


            // System.out.println("Before Clicking Drowndown Button: "+driver.findElement(By.id("divpaxinfo")).getText());
            driver.findElement(By.id("divpaxinfo")).click();
            pause();
                for(int i=0 ; i<4 ; i++){
                    driver.findElement(By.id("hrefIncAdt")).click();
                }
                for(int j=0; j<2;j++){
                    driver.findElement(By.id("hrefIncChd")).click();
                }
                for (int k=0;k<1;k++){
                    driver.findElement(By.id("hrefIncInf")).click();
                }
            driver.findElement(By.id("btnclosepaxoption")).click();

            pause();
            WebElement statDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"))  ;  
            Select mySelection = new Select(statDropdown);
            mySelection.selectByIndex(3);

            driver.findElement(By.cssSelector("div#ctl00_mainContent_SeniorCitizenDiv")).click();
            
            pause();
            driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$btn_FindFlights']")).click();

            pause();;
            driver.quit();
        }
        else{
            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            driver.findElement(By.xpath("//a[@value='PYG']")).click();
            pause();
            driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='JLR']")).click();;
            pause();
            driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
            pause();

            System.out.println("Before Clicking Drowndown Button: "+driver.findElement(By.id("divpaxinfo")).getText());
            driver.findElement(By.id("divpaxinfo")).click();
            pause();
                for(int i=0 ; i<4 ; i++){
                    driver.findElement(By.id("hrefIncAdt")).click();
                }
                for(int j=0; j<2;j++){
                    driver.findElement(By.id("hrefIncChd")).click();
                }
                for (int k=0;k<1;k++){
                    driver.findElement(By.id("hrefIncInf")).click();
                }
            driver.findElement(By.id("btnclosepaxoption")).click();

            pause();
            WebElement statDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"))  ;  
            Select mySelection = new Select(statDropdown);
            mySelection.selectByIndex(3);

            driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$btn_FindFlights']")).click();
            
            driver.quit();
        }
    }

    public static void pause() throws InterruptedException{
        Thread.sleep(1500);
    }
    
}
