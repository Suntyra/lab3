import helpers.WebdriverSettings;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationViaSocialNetworksTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebdriverSettings.getDriver();
    }

    @Test
    public void testRegistrationViaSocialNetworksGoogle() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Continue with Google')]")).click();
        assertThat(driver.findElement(By.xpath("//div[contains(text(), 'Войдите в аккаунт Google')]")).getText(), is("Войдите в аккаунт Google"));
        driver.quit();
    }

    @Test
    public void testRegistrationViaSocialNetworksFacebook() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Continue with Facebook')]")).click();
        assertThat(driver.findElement(By.xpath("//div[contains(text(), 'Log in to Facebook')]")).getText(), is("Log in to Facebook"));
        driver.quit();
    }

    @Test
    public void testRegistrationViaSocialNetworksApple() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Continue with Apple')]")).click();
        assertThat(driver.getTitle(), is("Sign in with Apple ID"));
        driver.quit();
    }
}

