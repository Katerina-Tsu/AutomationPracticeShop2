package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CreateAnAccountPage;
import pages.CreateNewAddressPage;
import pages.HeaderPage;
import pages.SignInPage;
import test_data.TestConstants;

import java.util.concurrent.TimeUnit;

public class BaseTest implements TestConstants {
    WebDriver driver;
    SignInPage signInPage;
    HeaderPage headerPage;
    CreateAnAccountPage createAnAccountPage;
    CreateNewAddressPage createNewAddressPage;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        initPage();
    }

    @AfterMethod(alwaysRun = true)
    public void endTest() {
        driver.quit();
    }

    public void initPage() {
        signInPage = new SignInPage(driver);
        headerPage = new HeaderPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
    }
}
