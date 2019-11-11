package com.testdetective.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestSetup {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/testdetective/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}


