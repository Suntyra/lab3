import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EditProfileTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/suntyra/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/home/suntyra/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void testEditProfile() throws InterruptedException {
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Log in with email')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email-input']")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).sendKeys("artyom99@bk.ru");
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).click();
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).sendKeys("Dsde@4d1.ds");
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//img[@name='user-avatar']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div/div/ul/li[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Edit')]")).click();
        driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Name*')]")).click();
        driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Name*')]")).sendKeys(Keys.LEFT_CONTROL + "A");
        driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Name*')]")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Name*')]")).sendKeys("artyom12");
        driver.findElement(By.xpath("//textarea[contains(@placeholder, '@Handle*')]")).click();
        driver.findElement(By.xpath("//textarea[contains(@placeholder, '@Handle*')]")).sendKeys(Keys.LEFT_CONTROL + "A");
        driver.findElement(By.xpath("//textarea[contains(@placeholder, '@Handle*')]")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//textarea[contains(@placeholder, '@Handle*')]")).sendKeys("artyom12");
        driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Add your bio')]")).click();
        driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Add your bio')]")).sendKeys("artyom12");
        driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Location')]")).click();
        driver.findElement(By.xpath("//textarea[contains(@placeholder, 'Location')]")).sendKeys("artyom12");
        driver.findElement(By.xpath("//span[contains(text(), 'Save')]")).click();
        assertThat(driver.findElement(By.xpath("//h1[contains(text(), 'artyom12')]")).getText(), is("artyom12"));
        driver.quit();
    }
}
