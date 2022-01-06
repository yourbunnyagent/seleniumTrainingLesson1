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
        driver.get("http://localhost:8080/litecart/");
        wait.until(titleIs("Online Store | My Store"));
        driver.findElements(By.cssSelector(".product.column.shadow.hover-light")).forEach(el -> {
            var elems = el.findElements(By.className("sticker"));
            if(elems.size() != 1) {
                throw new NoSuchElementException("count of stickers !=1");
            } else {
                System.out.println(elems.get(0).getText());
            }

        });

}

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}