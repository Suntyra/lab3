import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ResetPasswordTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/suntyra/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/home/suntyra/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void testResetPassword() throws InterruptedException {
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Log in with email')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(), 'Reset Password')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email-input']")).sendKeys("test@bk.ru");
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.xpath("//span[@id='message-id']")).getText(), is("Please check your email for further instructions."));
        driver.quit();
    }
}
