import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationTest {
    @Test
    public void testRegistration() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "/home/suntyra/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/home/suntyra/geckodriver");

        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();

        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(), 'Sign up')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email-input']")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).sendKeys("test@mail.ru");
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).click();
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).sendKeys("test@mail.ru");
        driver.findElement(By.xpath("//p[contains(text(), 'I have read and accepted the ')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'I agree to be contacted by email')]")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
