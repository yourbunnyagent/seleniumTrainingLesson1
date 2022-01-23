package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class myFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myFirstTest() {

            driver.get("http://localhost:8080/litecart/");


            for(int i = 1; i < 4; i ++) {
                driver.findElement(By.cssSelector("#box-most-popular .product:nth-child("+i+")")).click();
                WebElement num = driver.findElement(By.cssSelector("span.quantity"));
                int count = Integer.parseInt(num.getAttribute("textContent"));
                if (driver.findElements(By.name("options[Size]")).size() > 0){
                    driver.findElement(By.cssSelector("[name='options[Size]'] option:nth-child(2)")).click(); // Защита от жёлтой утки.
                }
                driver.findElement(By.name("add_cart_product")).click();
                wait.until(attributeContains(num, "textContent", String.valueOf(count+1)));
                driver.navigate().back();  //При этом на главной странице товары перемешиваются. Ничего с этим поделать не могу, поэтому просто выбираю следующий по счёту.
                wait.until(presenceOfElementLocated(By.cssSelector("#box-most-popular")));
            }


        driver.findElement(By.cssSelector("#cart a.link")).click();
        wait.until(presenceOfElementLocated(By.cssSelector(".shortcut a")));
        int n = driver.findElements(By.cssSelector(".shortcut a")).size();

        for(int j = 1; j < n; j ++) {

            int del = driver.findElements(By.cssSelector(".dataTable tr")).size();

            WebElement last = driver.findElement(By.cssSelector(".dataTable tr:nth-child("+del+")"));
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(last));
        }

    }

        @After
        public void stop () {
            driver.quit();
            driver = null;
        }
    }
