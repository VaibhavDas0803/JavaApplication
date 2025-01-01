package com.test.deployApp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTests {
    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().driverVersion("131.0.6778.204").setup();
    }

    @Test
    public void testGetOneEmployees() {
        // Set Chrome options to run headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("http://localhost:8083/employees/1");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testGetAllEmployees() {
        // Set Chrome options to run headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        
        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("http://localhost:8083/employees");
        } finally {
            driver.quit();
        }
    }
}
