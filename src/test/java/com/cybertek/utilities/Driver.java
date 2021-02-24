package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    //SINGLETON DESIGN PATTERN:
    //    #1- We create private constructor.
    private Driver() {
    } //not to create an obj of this class Driver driver = new Driver() xxxxxx

    private static WebDriver driver;


    //    #2- We create a getter method for the object of this class so that it will be returned in the way we want to offer.

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }
        }

//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //This same driver will be returned every time we call Driver.getDriver() method
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit(); //terminate here completely
            driver = null; //that`s why this line is needed again
        }
    }




}
