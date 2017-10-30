package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = ".//*[@id='email']")
	WebElement emailtxtbox;

	@FindBy(xpath = ".//*[@id='password']")
	WebElement passwordtxtbox;

	@FindBy(xpath = ".//*[@id='signInBtn']")
	WebElement signInBtn;

	By signOutlink = By.xpath(".//*[@id='globalHeaderSignout']");

	public void loginApplication(String email, String password) {

		emailtxtbox.sendKeys(email);
		passwordtxtbox.sendKeys(password);
		signInBtn.click();
	}

	public String getApplicationTitle() {
		return driver.getTitle();
	}

	public void verifySignOutlink() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signOutlink));
		String text = ele.getText();

		Assert.assertEquals(text, "(SIGN OUT)", "Sign Out link not present");
	}

}
