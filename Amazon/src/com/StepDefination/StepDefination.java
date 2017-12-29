package com.StepDefination;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefination {
	
public static WebDriver driver;
	
	@Given("^I am in home page$")
		public void i_am_in_home_page() throws Throwable {
		
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.co.uk/");
		}

	@When("^I click on search textbox and enter the product name$")
		public void i_click_on_search_textbox_and_enter_the_product_name() throws Throwable {
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 7");
	    }

	@When("^I click on search button$")
		public void i_click_on_search_button() throws Throwable {
			driver.findElement(By.className("nav-input")).click();
		}

	@When("^I Select product quantity$")
		public void i_Select_product_quantity() throws Throwable {
			 driver.findElement(By.cssSelector(".a-size-base.s-inline.s-access-title.a-text-normal")).click();
	           Select dropdown=new Select(driver.findElement(By.id("quantity")));
			  dropdown.selectByIndex(5);
		 }

	@When("^I click on Add to cart button$")
		public void i_click_on_Add_to_cart_button() throws Throwable {
			 driver.findElement(By.id("add-to-cart-button")).click();
		     Thread.sleep(2000);
		}

	@Then("^I should see product quantity in basket$")
		public void i_should_see_product_quantity_in_basket() throws Throwable {
			driver.findElement(By.cssSelector("#nav-cart-count")).getText();
			 Assert.assertEquals("6", driver.findElement(By.cssSelector("#nav-cart-count")).getText());
		}
	@Given("^I click on login/register link$")
	public void i_click_on_login_register_link() throws Throwable {
	   driver.findElement(By.linkText("Tu Log In / Register")).click();
	}

	@When("^I click on register button$")
	public void i_click_on_register_button() throws Throwable {
	   driver.findElement(By.cssSelector(".tuButton.regToggle")).click();
	   
	}

	@Given("^I am in Tuclothing home page$")
	public void i_am_in_Tuclothing_home_page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://tuclothing.sainsburys.co.uk/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	}


	@When("^I enter all the details regarding registration$")
	public void i_enter_all_the_details_regarding_registration(DataTable Register) throws Throwable {
		List<Map<String,String>>data=Register.asMaps(String.class, String.class);
		System.out.println(data.size());
	String email= data.get(0).get("Email address");
	String Title=data.get(0).get("Title");
    String firstname=data.get(0).get("First name");
	String surname=data.get(0).get("Surname");
	String password=data.get(0).get("Password");
	String confirmPassword=data.get(0).get("Confirm Password");
	
	
		/*Map<String, String> data=Register.asMap(String.class, String.class);
		String email=data.get("Email address");
		String Title=data.get("Title");
	    String firstname=data.get("First name");
		String surname=data.get("Surname");
		String password=data.get("Password");
		String confirmPassword=data.get("Confirm Password");*/
		
		driver.findElement(By.id("register_email")).sendKeys(email);
		WebElement ele = driver.findElement(By.id("register_title"));
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(Title);
		driver.findElement(By.id("register_firstName")).clear();
		driver.findElement(By.id("register_firstName")).sendKeys(firstname);
		driver.findElement(By.id("register_lastName")).clear();
		driver.findElement(By.id("register_lastName")).sendKeys(surname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("register_checkPwd")).clear();
		driver.findElement(By.id("register_checkPwd")).sendKeys(confirmPassword);
		
		
	}

	@When("^I click on terms and conditions button$")
	public void i_click_on_terms_and_conditions_button() throws Throwable {
		driver.findElement(By.id("Terms & Conditions & Privacy Policy")).click();
	}

	@Then("^I click on complete registration button$")
	public void i_click_on_complete_registration_button() throws Throwable {
		driver.findElement(By.className("registerButton")).click();
		 
	}
	@Then("^I should see welcome page$")
	public void i_should_see_welcome_page() throws Throwable {
		 Assert.assertTrue((driver.getPageSource()).contains("Thank you for registering with Tu"));
	}

	@When("^I enter details of \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_details_of_and(String email, String title, String firstname, String surname, String password, String confirmpassword) throws Throwable {
		driver.findElement(By.id("register_email")).sendKeys(email);
		WebElement ele = driver.findElement(By.id("register_title"));
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(title);
		driver.findElement(By.id("register_firstName")).clear();
		driver.findElement(By.id("register_firstName")).sendKeys(firstname);
		driver.findElement(By.id("register_lastName")).clear();
		driver.findElement(By.id("register_lastName")).sendKeys(surname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("register_checkPwd")).clear();
		driver.findElement(By.id("register_checkPwd")).sendKeys(confirmpassword);
		
		
	}

}
