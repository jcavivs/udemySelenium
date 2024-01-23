package com.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;

public class Brokenlinks {

    public static void main(String[] args) throws MalformedURLException, IOException {
        
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> list = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        // SoftAssert sortAssert = new SoftAssert();
        for(WebElement link : list){
            String url = link.getAttribute("href");
           
            HttpURLConnection urlConnect = (HttpURLConnection)new URL(url).openConnection(); ;
        
            urlConnect.setRequestMethod("HEAD");
            urlConnect.connect();
            int response = urlConnect.getResponseCode();
            // Assert.assertTrue(response<400,url+" - "+response);
            // System.out.println(response);

            if(response>400){
                System.out.println(url+" - "+response);
                Assert.assertTrue(response>=400);
            }
            else{
                Assert.assertTrue(response<400);;
            }
          
        }    
        driver.quit();
        // sortAssert.assertAll();
    }
}
