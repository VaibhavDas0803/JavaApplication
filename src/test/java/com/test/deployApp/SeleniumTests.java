package com.test.deployApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumTests {
    private static final String BASE_URL = "http://localhost:8083"; // Make this configurable via environment variable
    private WebDriver driver;
    
    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().driverVersion("131.0.6778.204").setup();
    }
    
    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testGetOneEmployees() {
        try {
            // Wait for application to be ready
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> {
                    try {
                        webDriver.get(BASE_URL + "/employees/1");
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Test
    public void testGetAllEmployees() {
        try {
            // Wait for application to be ready
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> {
                    try {
                        webDriver.get(BASE_URL + "/employees");
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
