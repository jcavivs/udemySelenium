package com.example;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {
    public static void main(String[] args) throws InterruptedException {
        
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String productName[] = {"Cucumber","Beans","Beetroot","Tomato","Carrot","Grapes","Banana"};
        Thread.sleep(3000);

        automateThis(driver, productName);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
        Thread.sleep(1500);
         WebElement promoCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        promoCode.sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.promoBtn")));
      
        String info = driver.findElement(By.className("promoInfo")).getText();
            if(info.contains("Code applied")){
                System.out.println(info);
                driver.findElement(By.xpath("//button[text()='Place Order']")).click();
            }
            else{
                System.out.println(info);

                driver.findElement(By.xpath("//button[text()='Place Order']")).click();
            }
    }
    public static void automateThis(ChromeDriver driver, String[] productName){

        int j = 0;
        List<WebElement> producto = driver.findElements(By.cssSelector("h4.product-name"));

        List nameOfproduct = Arrays.asList(productName);

            for(int i=0; i<producto.size();i++){
               
                String[] item = producto.get(i).getText().split("-");
                String trimmedName = item[0].trim();

                    if(nameOfproduct.contains(trimmedName)){
                        driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                        System.out.println(producto.get(i).getText());
                        if(j==productName.length){
                        break;
                        }
                    }                    
            }
    }
}
