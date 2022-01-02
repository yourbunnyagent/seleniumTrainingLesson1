package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testBase {

    public WebDriver chromedriver;
    public WebDriver firefoxdriver;
    public WebDriver explorerdriver;
    public WebDriverWait wait1;
    public WebDriverWait wait2;
    public WebDriverWait wait3;

    @Before
    public void start(){
        chromedriver = new ChromeDriver();
        explorerdriver = new InternetExplorerDriver();
        firefoxdriver = ;
        wait1 = new WebDriverWait(chromedriver, 10);
        wait2 = new WebDriverWait(firefoxdriver, 10);
        wait3 = new WebDriverWait(explorerdriver, 10);
    }

    @After
    public void stop() {
        firefoxdriver.quit();
        firefoxdriver = null;
        chromedriver.quit();
        chromedriver = null;
        explorerdriver.quit();
        explorerdriver = null;
    }
    }
}
