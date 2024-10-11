package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage_Pojo;
import pages.SignInPage_Pojo;
import utilities.BaseClass;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class HomePage_Stepdef {
	
	 public static WebDriver driver;
     private HomePage_Pojo homepage;
     private SignInPage_Pojo signInPage;
//     private AddToCart_Pojo addCartPage;

	@Given("Launch Amazon URL")
	public void launch_amazon_url() {
		
		Properties prop = BaseClass.initializeProperties();
		driver = DriverFactory.getDriver();
		driver.get(prop.getProperty("applicationURLs"));
	}
	
	@When("Login User Account Credentials")
	public void login_user_account_credentials() {
		
		signInPage = new SignInPage_Pojo(driver);
		signInPage.clickSignInButtonInAccount();
		signInPage.enterUserName();
		signInPage.clickContinue();
		signInPage.enterPassword();
		signInPage.clickSignIn();
		
	}

	@Then("Verify User Logged Successfully")
	public void verify_user_logged_successfully() {
	    
		signInPage = new SignInPage_Pojo(driver);
		signInPage.verifySignInButtonIsNotInAccount();
		
	}



	
	@When("Click on Electronics Menu Bar")
	public void click_on_electronics_menu_bar() {
		
		homepage = new HomePage_Pojo(driver);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homepage.clickElectronicsMenuOption();
		
	}
	
	@And("Verify Mobiles and Accessories is Present in Sub Menu bar")
	public void verify_mobiles_and_accessories_is_present_in_sub_menu_bar() {
		
		homepage = new HomePage_Pojo(driver);
		homepage.verifyMobileAndAccessoriesMenuPresent();
	}
	
	@When("Goto Mobiles and Accessories and Click on Screen Guards")
	public void goto_mobiles_and_accessories_and_click_on_screen_guards() {
	    
		homepage = new HomePage_Pojo(driver);
		homepage.ClickScreenGuardsUnderMobilesAndAcce();
		
	}
	
	@When("Click on Second Screen Guard Product")
    public void click_on_second_screen_guard_product() {
         
		homepage = new HomePage_Pojo(driver);
		homepage.selectSecondProductInPage();
    	
    }
	
	@When("Add the Second Product to the Cart")
    public void add_the_second_product_to_the_cart() {
    	
		homepage = new HomePage_Pojo(driver);
    	homepage.addProductToCart();
    	
    }
	
	@Then("Check Added To Cart Text is Displayed")
	public void check_added_to_cart_text_is_displayed() {
	     
		homepage.validateAddedToCartTextPresent();
		
		
	}
	
	@Then("Navigate to the Cart Section")
	public void navigate_to_the_cart_section() {

		homepage.clickOnGoToCart();
		
	}
	
	@Then("Capture the Screenshot of Item Addded to Cart")
	public void capture_the_screenshot_of_item_addded_to_cart() throws IOException {

		homepage = new HomePage_Pojo(driver);
		HomePage_Pojo.takeScreenshot("SecondProduct");
		
	}



}
