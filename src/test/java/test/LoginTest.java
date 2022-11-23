package test;

import lombok.extern.flogger.Flogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

import java.io.IOException;

public class LoginTest extends Base {
    WebDriver driver;
    Logger log;
    @Test(dataProvider = "getLoginData")
    public void login(String username, String passward, String expectedresult) throws IOException, InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.MyaccountDropdown().click();
        log.debug("Clicked on My Account dropdown");
        landingPage.loginOption().click();
        log.debug("Clicked on login option");
        Thread.sleep(3000);
        LoginPage login = new LoginPage(driver);
        login.Emailidfield().sendKeys(username);
        log.debug("Email addressed got entered");
        login.passwardField().sendKeys(passward);
        log.debug("Password got entered");
        login.loginField().click();
        log.debug("Clicked on Login Button");
        AccountPage accountPage = new AccountPage(driver);
        String actual = null;
        try {
            if (accountPage.Editaccountinformation().isDisplayed()) {
                log.debug("User got logged in");
                actual = "Success";
            }
        } catch (Exception ex) {
            log.debug("User didn't log in");
            actual = "Failure";
        }
        Assert.assertEquals(actual, expectedresult);
    }

    @BeforeMethod
    public void openApplication() throws IOException {
        log = LogManager.getLogger(LoginTest.class.getName());
        driver = driverIntialize();
        log.debug("browser launched");
        driver.get(prop.getProperty("url"));
        log.debug("navigate to url");
    }

    @AfterMethod
    public void closure() {
        driver.close();
        log.debug("Browser got closed");
    }

    @DataProvider
    public Object[][] getLoginData() {
        Object[][] data = {{"rajat.joshi087@gmail.com", "rajat@786", "Success"}};
        return data;
    }

}
