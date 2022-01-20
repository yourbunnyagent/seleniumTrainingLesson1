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

        driver.findElement(By.cssSelector("#box-account-login a")).click();
        wait.until(titleIs("Create Account | My Store"));

        driver.findElement(By.cssSelector("[name=tax_id]")).sendKeys("Testing");
        driver.findElement(By.cssSelector("[name=company]")).sendKeys("Testing");
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Testing");
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Testing");
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys("Testing");
        driver.findElement(By.cssSelector("[name=address2]")).sendKeys("Testing");
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("13579");
        driver.findElement(By.cssSelector("[name=city]")).sendKeys("Testing");
        driver.findElement(By.cssSelector(".select2-selection__rendered")).click();
        driver.findElement(By.cssSelector(".select2-search__field")).sendKeys("united");
        driver.findElement(By.cssSelector(".select2-results__options li:nth-child(4)")).click();
        driver.findElement(By.cssSelector("select[name=zone_code]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=zone_code] option")));
        driver.findElement(By.cssSelector("[name=zone_code] option:nth-child("+(int)(Math.random()*64 +1)+")")).click();

        String eMail = (int) (Math.random()*100000)+"test@gmail.com";
        driver.findElement(By.cssSelector("[type=email]")).sendKeys(eMail);
        driver.findElement(By.cssSelector("input[type=tel]")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector("label input")).click();

        String pass = (int) (Math.random()*10000)+"passWord!";
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(pass);
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys(pass);
        driver.findElement(By.name("create_account")).click();
        wait.until(titleIs("Online Store | My Store"));

        driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click();
        wait.until(titleIs("Online Store | My Store"));

        driver.findElement(By.cssSelector("[name=email]")).sendKeys(eMail);
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(pass);
        driver.findElement(By.name("login")).click();

        wait.until(titleIs("Online Store | My Store"));
        driver.findElement(By.cssSelector("#box-account li:nth-child(4) a")).click();


    }

        @After
        public void stop () {
            driver.quit();
            driver = null;
        }
    }
