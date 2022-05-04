package htm.index.parabank.com.parasoft.parabank.testsuite;


import htm.index.parabank.com.parasoft.parabank.pages.HomePage;
import htm.index.parabank.com.parasoft.parabank.pages.LoginPage;
import htm.index.parabank.com.parasoft.parabank.pages.RegisterPage;
import htm.index.parabank.com.parasoft.parabank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test
    public void verifyThatSigningUpPageDisplay() {
        homePage.clickOnRegisterLink();
        String expectedText = "Signing up is easy!";
        String actualText = registerPage.getWelcomeText();
        Assert.assertEquals(actualText, expectedText, "Register process is failed");
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.enterFirstName("hihello");
        registerPage.enterLastName("cool");
        registerPage.enterStreet("TheAvenue");
        registerPage.enterCity("Texas");
        registerPage.enterState("USA");
        registerPage.enterZipCode("56789");
        registerPage.enterPhoneNumber("12345678901");
        registerPage.enterSsn("987654");
        registerPage.enterUserName("hihello123");
        registerPage.enterPassword("abcd123");
        registerPage.enterConfirmPassword("abcd123");
        registerPage.clickOnRegisterButton();
        String expectedMsg = "Your account was created successfully. You are now logged in.";
        String actualMsg = registerPage.getRegistrationText();
        Assert.assertEquals(actualMsg, expectedMsg, "Registered Successfully.");

    }
}

