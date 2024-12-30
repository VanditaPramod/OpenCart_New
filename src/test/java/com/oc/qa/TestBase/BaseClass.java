package com.oc.qa.TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;    //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
    public static WebDriver driver;
    public Logger logger; // Log4j
    public Properties p;

    @BeforeMethod(groups = {"Regression", "Sanity", "Master"})
    @Parameters({"OS", "Browser"})
    public void setup(@Optional("Windows") String os, @Optional("chrome") String br) throws IOException {
        // Load properties file only once
        if (p == null) {
            FileReader file = new FileReader("./src//test//resources//config.properties");
            p = new Properties();
            p.load(file);
        }

        logger = LogManager.getLogger(this.getClass()); // Log4j
        logger.info("Test setup started with OS: " + os + " and Browser: " + br);

        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // OS setup
            switch (os.toLowerCase()) {
                case "windows" : capabilities.setPlatform(Platform.WIN11);break;
                case "linux" :capabilities.setPlatform(Platform.LINUX);break;
                case "mac" : capabilities.setPlatform(Platform.MAC);break;
                default : {
                    System.out.println("No matching OS");
                    return;
                }
            }

            // Browser setup
            switch (br.toLowerCase()) {
                case "chrome":
                	capabilities.setBrowserName("chrome");
                	break;
                case "edge" : capabilities.setBrowserName("MicrosoftEdge");
                break;
                case "firefox" : capabilities.setBrowserName("firefox");
                break;
                default : {
                    System.out.println("No matching browser");
                    return;
                }
            }

            driver = new RemoteWebDriver(new URL("http://192.168.10.8:4444/wd/hub"), capabilities);
        } else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            // Local browser initialization
            switch (br.toLowerCase()) {
                case "chrome" : driver = new ChromeDriver();break;
                case "edge" :driver = new EdgeDriver();break;
                case "firefox" : driver = new FirefoxDriver();break;
                default : {
                    System.out.println("Invalid Browser");
                    return;
                }
            }
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("AppURL")); // Reading properties file
        driver.manage().window().maximize();
    }

    @AfterMethod(groups = {"Sanity", "Regression", "Master"})
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Close the browser
            
        }
    }
    public String randomNumer()
	{
		String generatenum=RandomStringUtils.randomNumeric(10);
				return generatenum;
	}
    // Utility methods
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphabetic(3) + "@" + RandomStringUtils.randomNumeric(3);
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}
