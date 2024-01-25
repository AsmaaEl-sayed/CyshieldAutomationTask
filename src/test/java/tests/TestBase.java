package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase extends ExtentReportManager{
	public static WebDriver driver;
	public static  String getScreenshootPath(String path) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File(path);
		FileUtils.copyFile(source, DestFile);
		return path;
	}	
    @BeforeSuite
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
      	System.out.println(System.getProperty("user.dir"));
    }

    public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @Test()
    public void navigteToRegisterForm() throws Exception {
        driver.navigate().to("https://testing.todorvachev.com/register-form/");
    }

    @AfterSuite
    public void closeDriver() {
    	driver.quit();
        extent.flush();
    }
}
