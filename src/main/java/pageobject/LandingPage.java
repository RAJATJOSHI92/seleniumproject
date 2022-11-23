package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myaccountdropdown;
    @FindBy(css = "li[class='dropdown open'] li:nth-child(2) a:nth-child(1)")
    WebElement loginoption;

    public WebElement MyaccountDropdown() {
        return myaccountdropdown;
    }

    public WebElement loginOption() {
        return loginoption;
    }
}
