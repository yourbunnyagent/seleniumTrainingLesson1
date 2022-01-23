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

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;


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

            driver.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("remember_me")).click();
            driver.findElement(By.name("login")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.button")));
            driver.findElement(By.cssSelector("a.button")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("i.fa-external-link")));
            List<WebElement> links = driver.findElements(By.cssSelector("i.fa-external-link"));

            String winHandleBefore = driver.getWindowHandle();

            for (int i=0; i<links.size(); i++){

                links.get(i).click();

                ArrayList<String> windows = new ArrayList (driver.getWindowHandles());


                if (winHandleBefore == windows.get(0)){
                    driver.switchTo().window(windows.get(1));
                    driver.close();
                    driver.switchTo().window(windows.get(0));
                } else{
                    driver.switchTo().window(windows.get(0));
                    driver.close();
                    driver.switchTo().window(windows.get(1));

                }
        }

    }

        @After
        public void stop () {
            driver.quit();
            driver = null;
        }
    }
