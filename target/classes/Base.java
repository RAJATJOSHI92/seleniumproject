package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Base {
    WebDriver driver;
    public Properties prop;

    public WebDriver driverIntialize() throws IOException {
        prop = new Properties();
        FileInputStream fil = new FileInputStream("/Users/macbookpro/IdeaProjects/FramworkProject/src/main/java/resources/data.properties");
        prop.load(fil);
        String browsername = prop.getProperty("browser");

        if (browsername.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public void takeScreenshot(String testName, WebDriver driver) throws IOException {
        File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFilePath ="/Users/macbookpro/IdeaProjects/FramworkProject/Screenshot/"+testName+".png";
        FileUtils.copyFile(SourceFile,new File(destinationFilePath));
    }
}
