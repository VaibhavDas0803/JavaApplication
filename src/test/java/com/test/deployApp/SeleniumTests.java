package com.test.deployApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.BeforeEach;
import java.time.Duration;

public class SeleniumTests {
 private static final String BASE_URL = System.getenv("BASE_URL") != null ? System.getenv("BASE_URL") : "http://localhost:8083"; // Make this configurable via environment variable
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Implicit wait for elements
    }

    @Test
    public void testGetOneEmployees() {
        try {
            // Wait for application to be ready and for the employee element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.get(BASE_URL + "/employees/1");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee-details"))); // Assuming an element with id 'employee-details' is present on the page
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Test
    public void testGetAllEmployees() {
        try {
            // Wait for application to be ready and for the employee list to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.get(BASE_URL + "/employees");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee-list"))); // Assuming an element with id 'employee-list' is present on the page
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
