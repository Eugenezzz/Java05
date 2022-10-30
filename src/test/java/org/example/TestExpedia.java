package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestExpedia {
    static {
        WebDriverManager.chromedriver().setup();
    }
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExpedia() {
        driver.get ("https://www.expedia.com/");
        driver.findElement(By.xpath("//span[text()='Flights']\n")).click();
        Assert.assertEquals(driver.getTitle(), "Expedia Travel: Vacation Homes, Hotels, "
                + "Car Rentals, Flights & More");
    }
}

