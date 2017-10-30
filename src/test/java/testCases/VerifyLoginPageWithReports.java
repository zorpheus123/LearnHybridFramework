package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPageWithReports {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	@BeforeMethod
	public void setUP() {

		report = new ExtentReports("./Reports/LoginPageReport.html", true);

		logger = report.startTest("Verify Login Page");

		driver = BrowserFactory.getBrowser("chrome");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl());

		logger.log(LogStatus.INFO, "Application is up and running");

	}

	@Test
	public void testLoginPage() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		String title = home.getApplicationTitle();

		Assert.assertTrue(title.contains("Macy's - Shop Fashion Clothing & Accessories - Official Site - Macys.com"));

		logger.log(LogStatus.PASS, "Home Page loaded successfully and verified");

		home.clickonsigninlink();

		logger.log(LogStatus.INFO, "Clicked on Sign IN link");

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.loginApplication(DataProviderFactory.getExcelData().getData(0, 0, 0),
				DataProviderFactory.getExcelData().getData(0, 0, 1));

		logger.log(LogStatus.INFO, "Login Successful");

		login.verifySignOutlink();

		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.takeScreenshot(driver, "SignOutVerified")));

		logger.log(LogStatus.PASS, "Sign Out link is present: testLoginPage successfully verified");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String path = Helper.takeScreenshot(driver, result.getName());

			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}

		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();

	}
}
