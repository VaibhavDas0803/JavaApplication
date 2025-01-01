package com.test.deployApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Automatically manage ChromeDriver for the current OS
        WebDriverManager.chromedriver().setup();

        // Configure Chrome to run in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Initialize WebDriver with the configured options
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            // Close the browser after each test
            driver.quit();
        }
    }

    @Test
    public void testGetOneEmployees() {
        // Access the application
        driver.get("http://localhost:8083/employees/1");

        // Example verification (replace with your own checks)
        // WebElement employeeDetail = driver.findElement(By.id("employeeDetail"));
        // assertEquals(true, employeeDetail.isDisplayed(), "Employee details should be visible");

        System.out.println("testGetOneEmployees executed successfully.");
    }

    @Test
    public void testGetAllEmployees() {
        // Access the application
        driver.get("http://localhost:8083/employees");

        // Example verification (replace with your own checks)
        // WebElement employeeList = driver.findElement(By.id("employeeList"));
        // assertEquals(true, employeeList.isDisplayed(), "Employee list should be visible");

        System.out.println("testGetAllEmployees executed successfully.");
    }
}

