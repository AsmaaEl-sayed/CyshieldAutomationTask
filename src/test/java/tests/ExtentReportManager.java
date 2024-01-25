package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	static WebDriver driver;
	ExtentReports extent;
	@BeforeSuite
	public void setup() throws IOException {
		extent=new ExtentReports();
		ExtentSparkReporter spark= new ExtentSparkReporter("reportWithScreenshoot.html");
		spark.loadXMLConfig(new File("extentReport.xml"));
		extent.attachReporter(spark);
	}
	@AfterSuite
	public  void teardown() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("reportWithScreenshoot.html").toURI());	
	}
}
