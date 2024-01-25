package tests;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.RegisterFormPage;

public class RegisterFormTest extends TestBase {
    RegisterFormPage registerElement;
    
    @Parameters("browser")
    @BeforeTest
    public void initializeObjects(@Optional("chrome") String browser) {
        initializeDriver(browser);
        registerElement = new RegisterFormPage(driver);
    }
 
	@Test(priority = 0)
	public void checkVisability() throws IOException { 
	registerElement = new RegisterFormPage(driver);
	}

	@Test(priority = 1)
	public void fillFormWithValiddata() throws InterruptedException, IOException {
		ExtentTest test = extent.createTest("fillFormWithValiddata");
		registerElement.Form("123456","1234567", "Test" ,"6october","Australia" ,"0000" , "asmaa@yahoo.com");
		test.info("fillFormWithValiddata", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshootPath(System.getProperty("user.dir")+"/screenShoots/fillFormWithValiddata.png")).build());
	}
	@Test(priority = 2)
	public void fillFormWithInValiddata() throws InterruptedException, IOException {
		ExtentTest test = extent.createTest("fillFormWithInValiddata");
		registerElement.Form("ss","ssss", "s" ,"6 october","Australia" ,"ss" , "asma");
		registerElement.testTriggerAlert(driver);
		test.info("fillFormWithInValiddata", MediaEntityBuilder.createScreenCaptureFromPath(getScreenshootPath(System.getProperty("user.dir")+"/screenShoots/fillFormWithInValiddata.png")).build());
	}
	}