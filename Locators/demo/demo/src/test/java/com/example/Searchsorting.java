package com.example;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Searchsorting {
    
    public static void main(String[] args) {
        
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.id("search-field")).sendKeys("che");

        List<WebElement> foodname = driver.findElements(By.xpath("//tr/td[1]"));

        List<WebElement> veggie = foodname.stream().filter(s->s.getText().contains("Cheese")).collect(Collectors.toList());
        
        veggie.stream().map(s->s.getText()).forEach(s->System.out.println(s));





    }
    
}
