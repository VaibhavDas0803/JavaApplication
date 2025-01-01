package com.test.deployApp;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {

    @Test
    public void testGetOneEmployees() {
        // Automatically manage ChromeDriver for the current OS and specific browser version
        WebDriverManager.chromedriver().browserVersion("131.0.6778.204").setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Access the application
            driver.get("http://localhost:8083/employees/1");

            // Example verification (you can replace this with your own checks)
            // WebElement employeeList = driver.findElement(By.id("employeeList"));
            // assertEquals(true, employeeList.isDisplayed(), "Employee list should be visible");
        } finally {
            // Close browser
            driver.quit();
        }
    }

    @Test
    public void testGetAllEmployees() {
        // Automatically manage ChromeDriver for the current OS and specific browser version
        WebDriverManager.chromedriver().browserVersion("131.0.6778.204").setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Access the application
            driver.get("http://localhost:8083/employees");

            // Example verification (you can replace this with your own checks)
            // WebElement employeeList = driver.findElement(By.id("employeeList"));
            // assertEquals(true, employeeList.isDisplayed(), "Employee list should be visible");
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
