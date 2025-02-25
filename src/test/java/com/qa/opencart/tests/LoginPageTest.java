package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.constants.AppError;
import com.qa.opencart.pages.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 100:Design login page for opencart")
@Story("US 101:design various features of open cart application")
@Feature("Feature 50:Login page feature")
@Owner("Monalisa Mohanty")
public class LoginPageTest extends BaseTest {
   @Description("Login page title")
   @Severity(SeverityLevel.MINOR)
   @Test
   public void loginPageTitleTest() {
	   ChainTestListener.log("Verifying login page title");
	   String actTitel=loginPage.getLoginPageTitle();
	   Assert.assertEquals(actTitel, AppConstants.LOGIN_PAGE_TITLE,AppError.TITLE_NOT_FOUND_ERROR);
	   
   }
   @Description("Login page url")
   @Severity(SeverityLevel.MINOR)
   @Test
   public void loginPageURLTest() {
	   String actURL=loginPage.getLoginPageURL();
	   Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION),AppError.URL_NOT_FOUND_ERROR);
	   
   }
   @Description("Forgot password link")
   @Severity(SeverityLevel.CRITICAL)
   @Test
   public void forgotPwdLinkExistTest() {
	   Assert.assertTrue(loginPage.isForgotPwdLinkExist(),AppError.ELEMENT_NOT_FOUND_ERROR);
   }
   @Description("checking user is able to login")
   @Severity(SeverityLevel.BLOCKER)
   @Test(priority=Integer.MAX_VALUE)
   public void loginTest() {
	  homePage= loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	   Assert.assertEquals(homePage.getHomePageTitle(),AppConstants.HOME_PAGE_TITLE,AppError.TITLE_NOT_FOUND_ERROR);

   }
   @Description("Page logo")
   @Severity(SeverityLevel.MINOR)
   @Test
   public void logoTest() {
	   Assert.assertTrue(commonsPage.isLogoDisplyed(), AppError.LOGO_NOT_FOUND_ERROR);
	   }
   @DataProvider
   public Object[][] getFooterData() {
	   return new Object[][] {
		   {"About Us"},
		   {"Contact Us"},
		   {"Brands"},
		   {"My Account"}
	   };
   }
   @Description("Checking page footers")
   @Severity(SeverityLevel.NORMAL)
   @Test(dataProvider="getFooterData")
   public void footerTest(String footerLink) {
	   Assert.assertTrue(commonsPage.checkFooterLink(footerLink));
	   }
}
