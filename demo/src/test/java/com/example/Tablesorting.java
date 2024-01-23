package com.example;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Tablesorting {

    public static void main(String[] args) {
        
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        WebElement dropdown = driver.findElement(By.id("page-menu"));
        Select mySelection = new Select(dropdown);

        driver.findElement(By.cssSelector("[class*='table-bordered'] th:first-child")).click();
        
        List<WebElement> firstColumn = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> tableList = firstColumn.stream().map(s->s.getText()).collect(Collectors.toList());
        List<String> newTable = tableList.stream().sorted().collect(Collectors.toList());
        
        Assert.assertTrue(newTable.equals(tableList));

        // newTable.stream().forEach(s->System.out.println(s));
        // for(int i=0; i<firstColumn.size();i++){
        //     System.out.println(firstColumn.get(i).getText());
        // }

        // ** Get Price of the RICE **

        // Scan the name column and price of it 
        List<String> priceUnit ;
        do{
            List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));

            priceUnit=row.stream().filter(s->s.getText().contains("Chee")).map(s->getPriceVeggie(s)).collect(Collectors.toList());

            if(priceUnit.size()<1){
                driver.findElement(By.cssSelector("a[aria-label$='Next']")).click();
            }
            priceUnit.forEach(s->System.out.println("Cheese : " + s));
        }
        while(priceUnit.size()<1); 
        
    }

    // 
    private static String getPriceVeggie(WebElement element) {
        String pricevalue =   element.findElement(By.xpath("following-sibling::td[1]")).getText();
      return pricevalue;
    }
    
}
