package com.test.deployApp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// @SpringBootTest
public class SeleniumTests {

    // @Before
    // public void setup() {
    //     // Wait for the Spring application to be up
    //     waitForApplicationToStart();
    // }
    @Test
    public void testGetOneEmployees() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            // Access the application
            driver.get("http://localhost:8083/employees/1");

            // Verify employee list is displayed
            // WebElement employeeList = driver.findElement(By.id("employeeList"));
            // assertEquals(true, employeeList.isDisplayed(), "Employee list should be visible");
        } finally {
            // Close browser
            // driver.quit();
        }
    }

    @Test
    public void testGetAllEmployees() {

        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait.until(ExpectedConditions.urlContains("/employees"));
        try {
            // Access the application
            driver.get("http://localhost:8083/employees");

            // Verify employee list is displayed
            // WebElement employeeList = driver.findElement(By.id("employeeList"));
            // assertEquals(true, employeeList.isDisplayed(), "Employee list should be visible");
        } finally {
            // Close browser
            // driver.quit();
        }
    }

}
