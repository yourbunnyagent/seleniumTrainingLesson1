package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


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

            driver.get("http://localhost:8080/litecart/admin/");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("login")).click();
            wait.until(presenceOfElementLocated(By.cssSelector("#box-apps-menu li:nth-child(2) a")));


            driver.findElement(By.cssSelector("#box-apps-menu li:nth-child(2) a")).click();
            wait.until(titleIs("Catalog | My Store"));
            driver.findElement(By.cssSelector(".dataTable tr:nth-child(3) a")).click();
            int count = driver.findElements(By.cssSelector(".dataTable tr")).size();
            driver.findElement(By.cssSelector("#content a:nth-child(2).button")).click();
            wait.until(titleIs("Add New Product | My Store"));

            driver.findElement(By.cssSelector("label:nth-child(3)")).click();
            driver.findElement(By.name("name[en]")).sendKeys("TestProduct1111");
            String code = (int) (Math.random()*100000)+"01";
            driver.findElement(By.name("code")).sendKeys(code);
            driver.findElement(By.cssSelector("[data-name='Rubber Ducks']")).click();
        driver.findElement(By.cssSelector("[data-name=Root]")).click();
            driver.findElement(By.cssSelector("[value='1-3']")).click();
            driver.findElement(By.name("quantity")).sendKeys("1500000000");

        Path path = Path.of("src\\test\\resources\\ducksus.jpg").toAbsolutePath();
        String str = path.toString();
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(str);

        driver.findElement(By.name("date_valid_from")).sendKeys("31121991");
        driver.findElement(By.name("date_valid_to")).sendKeys("12042300");


        driver.findElement(By.cssSelector(".index li:nth-child(2)")).click();
        wait.until(presenceOfElementLocated(By.name("manufacturer_id")));
        driver.findElement(By.cssSelector("[name=manufacturer_id] option:nth-child(2)")).click();
        driver.findElement(By.name("keywords")).sendKeys("Jesus God Duck");
        driver.findElement(By.name("short_description[en]")).sendKeys("The inclusion of a date or date range is encouraged where it would improve the short description as a disambiguation, or enhance it as a descriptive annotation.");
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("The inclusion of a date or date range is encouraged where it would improve the short description as a disambiguation, or enhance it as a descriptive annotation.");
        driver.findElement(By.name("head_title[en]")).sendKeys("HOLY YTKA");
        driver.findElement(By.name("meta_description[en]")).sendKeys("Jesus + duck");

        driver.findElement(By.cssSelector(".index li:nth-child(4)")).click();
        wait.until(presenceOfElementLocated(By.name("purchase_price")));
        driver.findElement(By.name("purchase_price")).sendKeys("343434");
        driver.findElement(By.cssSelector("[name=purchase_price_currency_code] option:nth-child(2)")).click();
        driver.findElement(By.name("prices[USD]")).sendKeys("343");
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("343343");
        driver.findElement(By.name("prices[EUR]")).sendKeys("203");
        driver.findElement(By.name("gross_prices[EUR]")).sendKeys("203343");
        driver.findElement(By.name("save")).click();

        wait.until(titleIs("Catalog | My Store"));

        driver.findElement(By.cssSelector(".dataTable tr:nth-child(3) a")).click();
        int count2 = driver.findElements(By.cssSelector(".dataTable tr")).size();

        if (count2 <= count) {
            throw new RuntimeException("Новый продукт не добавился"); // Проверил сто раз. Условие верное. Не понимаю, почему иногда ошибку ловит.
            }


    }

        @After
        public void stop () {
            driver.quit();
            driver = null;
        }
    }
