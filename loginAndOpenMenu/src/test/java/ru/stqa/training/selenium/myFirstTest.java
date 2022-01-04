package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.sql.DriverManager.println;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class myFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
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
        driver.findElement(By.cssSelector("#app-:nth-child(1)")).click();
        wait.until(titleIs("Template | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-logotype a")).click();
        wait.until(titleIs("Logotype | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(2)")).click();
        wait.until(titleIs("Catalog | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-product_groups")).click();
        wait.until(titleIs("Product Groups | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-option_groups")).click();
        wait.until(titleIs("Option Groups | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-manufacturers")).click();
        wait.until(titleIs("Manufacturers | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-suppliers")).click();
        wait.until(titleIs("Suppliers | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-delivery_statuses")).click();
        wait.until(titleIs("Delivery Statuses | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-sold_out_statuses a")).click();
        wait.until(titleIs("Sold Out Statuses | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-quantity_units a")).click();
        wait.until(titleIs("Quantity Units | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-csv a")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(3)")).click();
        wait.until(titleIs("Countries | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(4)")).click();
        wait.until(titleIs("Currencies | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(5)")).click();
        wait.until(titleIs("Customers | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-csv a")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-newsletter a")).click();
        wait.until(titleIs("Newsletter | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(6)")).click();
        wait.until(titleIs("Geo Zones | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(7)")).click();
        wait.until(titleIs("Languages | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-storage_encoding a")).click();
        wait.until(titleIs("Storage Encoding | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(8)")).click();
        wait.until(titleIs("Job Modules | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-customer a")).click();
        wait.until(titleIs("Customer Modules | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-shipping a")).click();
        wait.until(titleIs("Shipping Modules | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-payment a")).click();
        wait.until(titleIs("Payment Modules | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-order_total a")).click();
        wait.until(titleIs("Order Total Modules | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-order_success a")).click();
        wait.until(titleIs("Order Success Modules | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-order_action a")).click();
        wait.until(titleIs("Order Action Modules | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(9)")).click();
        wait.until(titleIs("Orders | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-order_statuses a")).click();
        wait.until(titleIs("Order Statuses | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(10)")).click();
        wait.until(titleIs("Pages | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(11)")).click();
        wait.until(titleIs("Monthly Sales | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-most_sold_products a")).click();
        wait.until(titleIs("Most Sold Products | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-most_shopping_customers a")).click();
        wait.until(titleIs("Most Shopping Customers | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(12)")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-defaults a")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-general a")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-listings a")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-images a")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-checkout a")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-advanced a")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-security a")).click();
        wait.until(titleIs("Settings | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(13)")).click();
        wait.until(titleIs("Slides | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(14)")).click();
        wait.until(titleIs("Tax Classes | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-tax_rates a")).click();
        wait.until(titleIs("Tax Rates | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(15)")).click();
        wait.until(titleIs("Search Translations | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-scan a")).click();
        wait.until(titleIs("Scan Files For Translations | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#doc-csv a")).click();
        wait.until(titleIs("CSV Import/Export | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(16)")).click();
        wait.until(titleIs("Users | My Store"));
        driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.cssSelector("#app-:nth-child(17)")).click();
        wait.until(titleIs("vQmods | My Store"));
        driver.findElement(By.cssSelector("h1"));


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}