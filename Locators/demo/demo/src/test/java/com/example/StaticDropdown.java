package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class StaticDropdown {
    public static void main(String[] args) throws InterruptedException {


        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //  DYNAMIC DROPDOWN APPROACH

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='PYG']")).click();
        Thread.sleep(1500); 
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='JLR']")).click();;
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();

        // STARTT OF STATIC DROPDOWN APPROACH
        System.out.println("Before Clicking Drowndown Button: "+driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1500);

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

        System.out.println("After Clicking Drowndown Button: "+driver.findElement(By.id("divpaxinfo")).getText());
        WebElement statDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"))  ;  
        Select mySelection = new Select(statDropdown);

        mySelection.selectByIndex(3);
        System.out.println(mySelection.getFirstSelectedOption().getText());
        mySelection.selectByVisibleText("AED");
        System.out.println(mySelection.getFirstSelectedOption().getText());
        mySelection.selectByValue("INR");
        System.out.println(mySelection.getFirstSelectedOption().getText());

        driver.quit();

    }
    
}
