package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomePage_Pojo {

	public static WebDriver driver;
	Actions act;

	public HomePage_Pojo(WebDriver driver) {

		HomePage_Pojo.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text() = 'Account & Lists']")
	private static WebElement oAccountAndListLabel;

	@FindBy(xpath = "//div[@id='nav-xshop-container']//following-sibling::a[text()=' Electronics ']")
	private WebElement oElectrnicsMenu;

	@FindBy(xpath = "//div[@id='nav-subnav']/child::a[contains(@aria-label,'Mobiles & Accessories')]/child::span[1]")
	private WebElement oMobAndAccessMenu;

	@FindBy(xpath = "//a[text()='Screen guards']")
	private WebElement oSafeGuardOption;

	@FindBy(xpath = "//span[contains(text(),'Best sellers')]//following::li[2]//a[@class='a-link-normal octopus-pc-item-link']")
	private WebElement oSelectSecondProduct;

	// =======================Add To Cart===================

	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement oProductName;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	private WebElement oAddToCartButton;

	// ======================================================

	// =======================Verify Add To Cart===================

	@FindBy(xpath = "//h1[contains(text(),'Added to Cart')]/parent::div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']")
	private WebElement oVerifyAddedToCartTextDispalyed;

	@FindBy(xpath = "//span[@id='sw-gtc']//child::a[contains(text(),'Go to Cart')]")
	private WebElement oGoToCartButton;
	
	@FindBy(xpath = "//div[@id='sc-active-cart']")
	private static WebElement oAddedProduct;

	// ======================================================

	public static void clickAccountAndList() {

		oAccountAndListLabel.click();

	}

	public void clickElectronicsMenuOption() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		oElectrnicsMenu.click();

	}

	public void verifyMobileAndAccessoriesMenuPresent() {

		String ExpectedResult = "Mobiles & Accessories";
		String ActualResult = oMobAndAccessMenu.getText();
		Assert.assertEquals(ExpectedResult, ActualResult);
		System.out.println("Mobiles & Accessories is Present in a Webpage");
	}

	public void clickSafeGuardMenu() {

		oSafeGuardOption.click();

	}

	public void ClickScreenGuardsUnderMobilesAndAcce() {

		act = new Actions(driver);
		act.moveToElement(oMobAndAccessMenu).build().perform();
		this.clickSafeGuardMenu();
	}

	public void selectSecondProductInPage() {

		act = new Actions(driver);
		act.moveToElement(oSelectSecondProduct).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		oSelectSecondProduct.click();

	}

	public String getProductText() {

		String prodName = oProductName.getText();
		return prodName;

	}

	public void addProductToCart() {

		System.out.println(getProductText());
		oAddToCartButton.click();

	}

	public void validateAddedToCartTextPresent() {

		Assert.assertTrue(oVerifyAddedToCartTextDispalyed.isDisplayed());
		System.out.println("Product Added and Added To Cart Text is displayed after adding");

	}

	public void clickOnGoToCart() {

		oGoToCartButton.click();

	}

	public static void takeScreenshot(String fileName) throws IOException {

		
		File sourceFile = oAddedProduct.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".jpg";
		FileUtils.copyFile(sourceFile, new File(destFile));

	}

}
