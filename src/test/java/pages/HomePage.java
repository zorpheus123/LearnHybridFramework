package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver ldriver) {

		this.driver = ldriver;

	}

	@FindBy(xpath = ".//*[@id='globalUserDetails']/div/a")
	WebElement signinlink;

	@FindBy(xpath = ".//*[@id='myAccountLink']")
	WebElement myaccountlink;

	@FindBy(xpath = ".//div[@class=\"redesign-header-links\"]//a[text()=\"STORES\"]")
	WebElement storeslink;

	@FindBy(xpath = ".//div[@class=\"redesign-header-links\"]//a[text()=\"DEALS\"]")
	WebElement dealslink;

	public void clickonsigninlink() {
		signinlink.click();

	}

	public void clickonmyaccountlink() {
		myaccountlink.click();

	}

	public void clickonstoreslink() {
		storeslink.click();

	}

	public void clickondealslink() {
		dealslink.click();

	}

	public String getApplicationTitle() {
		return driver.getTitle();

	}

}
