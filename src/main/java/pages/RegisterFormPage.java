package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class RegisterFormPage extends PageBase {
	public RegisterFormPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "userid")
	public WebElement userid;
	@FindBy(name = "passid")
	public WebElement passid;
	@FindBy(name = "username")
	public WebElement username;
	@FindBy(name = "address")
	public WebElement address;
	@FindBy(name = "country")
	public WebElement country;
	@FindBy(name = "zip")
	public WebElement zip;
	@FindBy(name = "email")
	public WebElement email;
	@FindBy(name = "sex")
	public WebElement sex;
	@FindBy(name = "submit")
	public WebElement submit;

	public void checkIfAllElementsAreVisible() {
		userid.isDisplayed();
		passid.isDisplayed();
		username.isDisplayed();
		address.isDisplayed();
		country.isDisplayed();
		zip.isDisplayed();
		email.isDisplayed();
		submit.isDisplayed();   
		}
	    public void Form(String userId, String passId , String userName , String Address ,String Country, String Zip , String Email) {
	        //scrollDownWithArrowKey(driver, 12);
	    	sendvalues(userid, userId);
	    	sendvalues(passid, passId);
	    	sendvalues(username, userName);
	    	sendvalues(address, Address);
	    	click(country);
	    	select(country, Country);
	    	sendvalues(zip, Zip);
	    	sendvalues(email, Email);
	    	click(submit); 
	    	  
	    }
	    public void testTriggerAlert(WebDriver driver) {
	        try {
	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	            System.out.println("Alert Text: " + alertText);
	            Assert.assertEquals("User Id should not be empty / length be between 5 to 12", alertText);
	            alert.accept();
	        } catch (Exception e) {
	            System.out.println("No alert present or unable to handle the alert.");
	        }
	    }
}
