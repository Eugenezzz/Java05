package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class GrubHubWithoutWManager {

    private WebDriver loadChromeDriver() {

        System.setProperty("webdriver.chromedriver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        this.driver = new ChromeDriver(options);
        return driver;
    }

    ChromeOptions chromeOptions;
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = loadChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testLoginPage() {
        driver.get("https://www.grubhub.com/");
        driver.findElement(By.cssSelector("[data-testid='prettyhomepagesignin']")).click();
        driver.findElement(By.cssSelector(".ghs-goToCreateAccount")).click();
        driver.findElement(By.id("firstName")).sendKeys("Vasya");
        driver.findElement(By.id("lastName")).sendKeys("Piterskiy");
        driver.findElement(By.id("email")).sendKeys("vasiliy@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Ababgalamaga1!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='captchaMediaImage']")).isDisplayed());
    }
}