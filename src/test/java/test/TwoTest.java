package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class TwoTest extends Base {
   public WebDriver driver;
    @Test
    public void twoTest() throws IOException, InterruptedException {
        System.out.println("test two");
       System.out.println("third attempt");
        System.out.println("fourth attempt");
       driver = driverIntialize();
       driver.get("http://www.tutorialsninja.com/demo/");
       Thread.sleep(2000);
        Assert.assertTrue(false);
    }
    @AfterMethod
    public void closure()
    {
        driver.close();
    }
}
