/*
 * package pages;
 * 
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.FindBy; import
 * org.openqa.selenium.support.PageFactory;
 * 
 * public class AddToCart_Pojo {
 * 
 * public static WebDriver driver;
 * 
 * public AddToCart_Pojo(WebDriver driver) {
 * 
 * AddToCart_Pojo.driver = driver; PageFactory.initElements(driver,
 * AddToCart_Pojo.class); }
 * 
 * @FindBy(xpath = "//span[@id='productTitle']") private WebElement
 * oProductName;
 * 
 * @FindBy(xpath = "//input[@id='add-to-cart-button']") private WebElement
 * oAddToCartButton;
 * 
 * public String getProductText() {
 * 
 * String prodName = oProductName.getText(); System.out.println(prodName);
 * return prodName;
 * 
 * }
 * 
 * public void addProductToCart() {
 * 
 * getProductText(); oAddToCartButton.click();
 * 
 * }
 * 
 * }
 */