package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class myFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void myFirstTest() {
        driver.get("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("Geo Zones | My Store"));


        var n = driver.findElements(By.cssSelector(".row")).size();


        for (int i = 0; i <= n - 1; i++) {//нет, ошибок нет. При выборе дочерних элементов в следующем цикле (:nth-child())

            driver.findElement(By.cssSelector(".row:nth-child(" + (i + 2) + ") td:nth-child(3)")).click();                            //получается нормально сформировать массив только с такими индексами.

            var p = driver.findElements(By.cssSelector("#table-zones tbody tr")).size();

            String[] countries = new String[n];

            for (int j = 0; j <= p - 1; j++) {
                var country = driver
                        .findElement(By.cssSelector("#table-zones tbody tr:nth-child(" + (j + 2) + ") td:nth-child(3) [selected=selected]"));
                countries[i] = country.getAttribute("textContent");
            }

            String[] sortCountries = countries;
            Arrays.sort(sortCountries);
            if (countries != sortCountries) {
                throw new NoSuchElementException("Rows aren't sorted!");
            }
        }
    }





        @After
        public void stop () {
            driver.quit();
            driver = null;
        }
    }
