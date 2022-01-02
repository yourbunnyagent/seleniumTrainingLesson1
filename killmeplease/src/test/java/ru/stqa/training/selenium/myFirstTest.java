package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class myFirstTest extends testBase {

    @Test
    public void myFirstTest() {
        chromedriver.get("http://www.google.com");
        chromedriver.findElement(By.name("q")).sendKeys("webdriver");
        chromedriver.findElement(By.name("q")).sendKeys(ENTER);
        //driver.findElement(By.name("btnK")).click();
        wait1.until(titleIs("webdriver - Поиск в Google"));
    }

    @Test
    public void mySecondTest() {
        firefoxdriver.get("http://www.google.com");
        firefoxdriver.findElement(By.name("q")).sendKeys("position.exchange");
        firefoxdriver.findElement(By.name("q")).sendKeys(ENTER);
        //driver.findElement(By.name("btnK")).click();
        wait2.until(titleIs("position.exchange - Поиск в Google"));
    }

    @Test
    public void myThirdTest() {
        explorerdriver.get("http://www.google.com");
        explorerdriver.findElement(By.name("q")).sendKeys("AAVE");
        explorerdriver.findElement(By.name("q")).sendKeys(ENTER);
        //driver.findElement(By.name("btnK")).click();
        wait3.until(titleIs("AAVE - Поиск в Google"));
    }

    @Test
    public void myFourthTest() {
        chromedriver.get("http://www.google.com");
        chromedriver.findElement(By.name("q")).sendKeys("Compound");
        chromedriver.findElement(By.name("q")).sendKeys(ENTER);
        //driver.findElement(By.name("btnK")).click();
        wait1.until(titleIs("Compound - Поиск в Google"));
    }
}
