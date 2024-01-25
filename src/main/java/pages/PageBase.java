package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public static void sendvalues(WebElement txt, String value) {
		txt.sendKeys(value);
	}

	public static void click(WebElement button) {
		button.click();
	}
	
	  public static void select(WebElement dropdownElement, String index) {
	        Select select = new Select(dropdownElement);
	        select.selectByVisibleText(index);
	  }    
	}

