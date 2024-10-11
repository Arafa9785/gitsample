package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factory.DriverFactory;

public class SignInPage_Pojo extends DriverFactory {

	public static WebDriver driver;
	Actions act;

	public SignInPage_Pojo(WebDriver driver) {

		SignInPage_Pojo.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='nav-tools']/child::a[@id='nav-link-accountList']")
	private WebElement oAccountAndList;

	@FindBy(xpath = "//div[@id='nav-flyout-accountList']//span[@class='nav-action-inner']")
	private WebElement oSignInAccountButton;

	@FindBy(xpath = "//input[@id='ap_email_login']")
	private WebElement oUserName;

	@FindBy(xpath = "//span[@id='continue']")
	private WebElement oClickContinueButton;

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement oPassword;

	@FindBy(id = "signInSubmit")
	private WebElement oSignIn;

	public void clickSignInButtonInAccount() {

		act = new Actions(driver);
		act.moveToElement(oAccountAndList).build().perform();
		oSignInAccountButton.click();

	}

	public void verifySignInButtonIsNotInAccount() {

		act = new Actions(driver);
		act.moveToElement(oAccountAndList).build().perform();
		Assert.assertTrue(!oSignInAccountButton.isDisplayed());
		System.out.println("Verified User Logged In Successfully");

	}

	public void enterUserName() {

		oUserName.sendKeys("9626702769");

	}

	public void clickContinue() {

		oClickContinueButton.click();

	}

	public void enterPassword() {

		oPassword.sendKeys("pa@25051997");

	}

	public void clickSignIn() {

		oSignIn.click();

	}

	public void verifyLoggedInSuccessfully() {

		HomePage_Pojo.clickAccountAndList();
		Assert.assertTrue(!oUserName.isDisplayed());
		driver.navigate().back();

	}

}
