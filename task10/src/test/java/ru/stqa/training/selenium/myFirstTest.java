package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
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


        String[] mainDuck = new String[11];
            mainDuck[0] = driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1) .name")).getAttribute("textContent");
            mainDuck[1] = driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1) s")).getAttribute("textContent"); // Проверка на зачёркнутость осуществляется благодаря обозначению тега s

                String colorSs = driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1) s")).getCssValue("color").substring(5);
                String[] colorS = colorSs.replace(",", "").replace(")", "").split(" ");
            mainDuck[2] = colorS[0];
            mainDuck[3] = colorS[1];
            mainDuck[4] = colorS[2];

            mainDuck[5] = driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1) s")).getCssValue("font-size");
            double mainBlack = Double.parseDouble(mainDuck[5].replace("px", ""));

            mainDuck[6] = driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1) strong")).getAttribute("textContent"); // Проверка на жирность осуществляется благодаря обозначению тега strong

                String colorRr = driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1) .campaign-price")).getCssValue("color").substring(5);
                String[] colorR = colorRr.replace(",", "").replace(")", "").split(" ");
            mainDuck[7] = colorR[1];
            mainDuck[8] = colorR[2];

            int mainRed = Integer.parseInt(driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1) .campaign-price")).getCssValue("font-size").replace("px", ""));



        driver.findElement(By.cssSelector("#box-campaigns li:nth-child(1) .link")).click();


        String[] subDuck = new String[11];

           subDuck[0] = driver.findElement(By.cssSelector("h1")).getAttribute("textContent");
           subDuck[1] = driver.findElement(By.cssSelector("#box-product s")).getAttribute("textContent");// Проверка на зачёркнутость осуществляется благодаря обозначению тега s

                String subColorSs = driver.findElement(By.cssSelector("#box-product s")).getCssValue("color").substring(5);
                String[] subColorS = subColorSs.replace(",", "").replace(")", "").split(" ");
            subDuck[2] = subColorS[0];
            subDuck[3] = subColorS[1];
            subDuck[4] = subColorS[2];

            subDuck[5] = driver.findElement(By.cssSelector("#box-product s")).getCssValue("font-size");
            int subBlack = Integer.parseInt (subDuck[5].replace("px", ""));
            subDuck[6] = driver.findElement(By.cssSelector("#box-product strong")).getAttribute("textContent"); // Проверка на жирность осуществляется благодаря обозначению тега strong

                String subColorRr = driver.findElement(By.cssSelector("#box-product strong")).getCssValue("color").substring(5);
                String[] subColorR = subColorRr.replace(",", "").replace(")", "").split(" ");
            subDuck[7] = subColorR[1];
            subDuck[8] = subColorR[2];

            int subRed = Integer.parseInt (driver.findElement(By.cssSelector("#box-product strong")).getCssValue("font-size").replace("px", ""));



        if (mainDuck[0].equals(subDuck[0])){   // проверка на совпадение названий

            if (mainDuck[1].equals(subDuck[1]) && mainDuck[6].equals(subDuck[6])){ //проверка на совпадение обычных и акционных цен

                if ((mainDuck[2].equals(mainDuck[3])) && (mainDuck[3].equals(mainDuck[4])) && (subDuck[2].equals(subDuck[3])) && subDuck[3].equals(subDuck[4])) {   // if a=b and b=c then a=c проверка на серость на главной странице и странице товара

                    if ((mainDuck[7].equals("0") && mainDuck[8].equals("0")) && (subDuck[7].equals("0") && subDuck[8].equals("0"))) { //ПРОВЕРКА НА КРАСНОСТЬ НА ГЛАВНОЙ СТРАНИЦЕ И СТРАНИЦЕ ТОВАРА

                        if ((mainRed > mainBlack) && (subRed > subBlack)) { //ПРОВЕРКА НА "акционная цена больше обычной"

                            System.out.println("Проверки пройдены, всё ок!");

                        } else {
                            throw new NullPointerException("Проверка на то, что акционная цена больше обычной, провалена!");
                        }

                    } else {
                        throw new NullPointerException("Проверка на красность акционной цены провалена!");
                    }

                } else {
                    throw new NullPointerException("Проверка на серость обычной цены провалена");
                }

            } else {
                throw new NullPointerException("Проверка на совпадение обычных цен провалена!");
            }

        } else {
            throw new NullPointerException("Проверка на совпадение названий товара провалена!");
        }
    }

    // Данная программа выстрадана кровавыми слезами. Было интересно её делать, но постоянно путался или натыкался на препятствия.
    // Насколько я могу судить, логических ошибок в ней нет.
    // Понимаю, что вполне возможно иду сложными путями, но программировать учусь на ходу, поэтому многого не знаю.
    // В любом случае, считаю, что оно того стоило. Интересное задание.


        @After
        public void stop () {
            driver.quit();
            driver = null;
        }
    }
