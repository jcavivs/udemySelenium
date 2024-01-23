package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
    public static void main(String[] args) {
        
        ChromeDriver driver = new ChromeDriver();
        
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println("Numbe of row display: " + driver.findElements(By.cssSelector(".table-display tr")).size());

        System.out.println("Number of column display: " + driver.findElements(By.cssSelector(".table-display tr th")).size());

        for(int i=0;i<driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td")).size();i++){
            System.out.println(driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td")).get(i).getText());
        }

        driver.quit();
        
    }
}
