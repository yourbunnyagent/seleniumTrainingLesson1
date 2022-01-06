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
        driver.get("http://localhost:8080/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        wait.until(titleIs("My Store"));

        var items = driver.findElements(By.cssSelector("#app-")).size();


        for (int i = 1; i <= items; i++){
            driver.findElement(By.cssSelector("#box-apps-menu #app-:nth-child("+i+")")).click();
            var subitems = driver.findElements(By.cssSelector("#app- li")).size();
            if (subitems == 0) {
                continue;
            } else for (int j = 1; j <= subitems; j++){
                driver.findElement(By.cssSelector("#app- li:nth-child("+j+")")).click();
                driver.findElement(By.cssSelector("h1"));
            }

        };

}

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}