package org.example.uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BaseUITest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
//        driver = new ChromeDriver();

//        driver = new EdgeDriver();

        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test() {
        driver.get("https://www.google.com/?hl=en-US");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Accept all']"))).click();

        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("webdriver");


//        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("webdriver");


        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[@name='btnK']")).click();

//        driver.findElements(By.name("btnK")).get(1).click();

//        List<WebElement> webElementList = driver.findElements(By.name("btnK"));
//        webElementList.get(1).click();

//        wait.until(titleIs("webdriver - Google Search"));

        Assert.assertEquals(driver.getTitle(), "webdriver - Google Search");

    }

    @AfterTest
    public void stop() {
//        driver.quit();
    }
}
