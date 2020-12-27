import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegistrationViaSocialNetworksTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/home/suntyra/chromedriver");
        //System.setProperty("webdriver.gecko.driver", "/home/suntyra/geckodriver");
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @Test
    public void testRegistrationViaSocialNetworksGoogle() throws InterruptedException {
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Continue with Google')]")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.xpath("//div[contains(text(), 'Войдите в аккаунт Google')]")).getText(), is("Войдите в аккаунт Google"));
        driver.quit();
    }

    @Test
    public void testRegistrationViaSocialNetworksFacebook() throws InterruptedException {
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Continue with Facebook')]")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.xpath("//div[contains(text(), 'Log in to Facebook')]")).getText(), is("Log in to Facebook"));
        driver.quit();
    }

    @Test
    public void testRegistrationViaSocialNetworksApple() throws InterruptedException {
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(text(), 'Continue with Apple')]")).click();
        Thread.sleep(1000);
        assertThat(driver.getTitle(), is("Sign in with Apple ID"));
        driver.quit();
    }
}

