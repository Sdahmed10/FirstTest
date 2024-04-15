import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Modularcode {
    public static String browser;
    static WebDriver driver;

    public static void main(String[] args) throws IOException {
        //setBrowser();
        PropertiesFile.readProperties();
        setBrowserConfig();
        runtest();
        PropertiesFile.writeProperties();
    }

    //set Browser
    //set BrowserConfig
    //run test
    public static void setBrowser() {
        browser = "Chrome";
    }

    public static void setBrowserConfig() {
        if (browser.contains("Firefox")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
        if (browser.contains("Chrome")) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
    }

    public static void runtest() {
        driver.get("https://www.google.fr/");
        driver.quit();
    }
}

