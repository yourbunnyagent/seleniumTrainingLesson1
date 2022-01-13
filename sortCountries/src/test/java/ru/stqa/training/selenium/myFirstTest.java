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
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        driver.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("Countries | My Store"));


        var n = driver.findElements(By.cssSelector(".row")).size();
        List<String> countries = new ArrayList<>();
        List<String> countriesReal = new ArrayList<>();




        for (int i = 0; i <= n-1; i++) { //нет, ошибок нет. При выборе дочерних элементов в следующем цикле (:nth-child())
                                        //получается нормально сформировать массив только с такими индексами.
            var country = driver
                    .findElement(By.cssSelector(".row:nth-child(" +(i+2)+ ") td:nth-child(5)")).getAttribute("textContent");
            countries.add(country);
            countriesReal.add(country);
            //System.out.println(country.getAttribute("textContent"));
        }
            if (!countries.stream().sorted().toList().equals(countriesReal)){
                throw new NoSuchElementException("Rows aren't sorted!");
            }

        int num1 = 0;

        for (int i = 0; i <= n-1; i++) { //нет, ошибок нет. При выборе дочерних элементов в следующем цикле (:nth-child())
                                         //получается нормально сформировать массив только с такими индексами.

            var num = driver
                    .findElement(By.cssSelector(".row:nth-child(" +(i+2)+ ") td:nth-child(6)"))
                    .getAttribute("textContent");
            try {
                num1 = Integer.parseInt(num);
            } catch (NumberFormatException e) {
                System.err.println("Неправильный формат строки!");
            }

            if (num1 != 0){
                driver.findElement(By.cssSelector(".row:nth-child(" +(i+2)+ ") td:nth-child(5) a")).click();
                var sCCount = driver
                        .findElements(By.cssSelector("#table-zones tbody tr")).size() - 2;
                List<String> subCountries = new ArrayList<>();
                List<String> subCountriesReal = new ArrayList<>();
                for (int k = 0; k <= sCCount-1; k++) { //нет, ошибок нет. При выборе дочерних элементов в следующем цикле (:nth-child())
                    //получается нормально сформировать массив только с такими индексами.
                    var subCountry = driver
                            .findElement(By.cssSelector("tbody tr:nth-child("+(k+2)+") td:nth-child(3)")).getAttribute("textContent");
                    subCountries.add(subCountry);
                    subCountriesReal.add(subCountry);
                }

                if (!subCountries.stream().sorted().toList().equals(subCountriesReal)){
                    throw new NoSuchElementException("Rows aren't sorted!");
                }
                driver.navigate().back();
            }

            //System.out.println(country.getAttribute("textContent"));
        }
    }



        @After
        public void stop () {
            driver.quit();
            driver = null;
        }
    }
