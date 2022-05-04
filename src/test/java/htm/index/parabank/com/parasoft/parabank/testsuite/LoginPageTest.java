package htm.index.parabank.com.parasoft.parabank.testsuite;

import htm.index.parabank.com.parasoft.parabank.pages.HomePage;
import htm.index.parabank.com.parasoft.parabank.pages.LoginPage;
import htm.index.parabank.com.parasoft.parabank.pages.RegisterPage;
import htm.index.parabank.com.parasoft.parabank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("hihello");
        loginPage.enterPassword("abcd123");
        loginPage.clickOnLoginButton();
        String expectedText = "Accounts Overview";
        String actualText = loginPage.getWelcomeText();
        Assert.assertEquals(actualText, expectedText, "SignIn Successfully");
    }

    @Test
    public void verifyTheErrorMessage() {
        loginPage.enterUserName("hihello");
        loginPage.enterPassword("abcd123");
        loginPage.clickOnLoginButton();
        String expectedText = "The username and password could not be verified.";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(actualText, expectedText, "Invalid Username & Password");
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        loginPage.enterUserName("hihello123");
        loginPage.enterPassword("abcd123");
        loginPage.clickOnLoginButton();
        loginPage.clickOnLogoutButton();
        String expectedText = "Customer Login";
        String actualText = loginPage.getLogoutText();
        Assert.assertEquals(actualText, expectedText, "Logout Successfully");
    }

}