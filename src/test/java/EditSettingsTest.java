import helpers.WebdriverSettings;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EditSettingsTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebdriverSettings.getDriver();
    }

    @Test
    public void testEditSettings() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'Log in')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Log in with email')]")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).sendKeys("artyom99@bk.ru");
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).click();
        driver.findElement(By.xpath("//input[@id='outlined-adornment-password']")).sendKeys("Dsde@4d1.ds");
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//span[contains(text(), 'Answer')]"))));
        driver.findElement(By.xpath("//img[@name='user-avatar']")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Settings')]")).click();
        driver.findElement(By.xpath("//h6[contains(text(), 'Subscribe to the weekly Answers Email')]")).click();
        assertThat(driver.findElement(By.xpath("//span[@id='message-id']")).getText(), is("We have received your request"));
        driver.findElement(By.xpath("(//span[@class='a316'])[5]")).click();
        driver.findElement(By.xpath("//h6[contains(text(), 'Email notifications')]")).click();
        assertThat(driver.findElement(By.xpath("//span[@id='message-id']")).getText(), is("We have received your request"));
        driver.findElement(By.xpath("(//span[@class='a316'])[5]")).click();
        driver.findElement(By.xpath("//h6[contains(text(), 'Website notifications')]")).click();
        assertThat(driver.findElement(By.xpath("//span[@id='message-id']")).getText(), is("We have received your request"));
        driver.findElement(By.xpath("(//span[@class='a316'])[5]")).click();
        driver.findElement(By.xpath("//h6[contains(text(), 'Mobile notifications')]")).click();
        assertThat(driver.findElement(By.xpath("//span[@id='message-id']")).getText(), is("We have received your request"));
        driver.findElement(By.xpath("(//span[@class='a316'])[5]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Reset my password')]")).click();
        assertThat(driver.findElement(By.xpath("//span[@id='message-id']")).getText(), is("Please check your email to reset your password."));
        driver.findElement(By.xpath("(//span[@class='a316'])[5]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Request GDPR info')]")).click();
        assertThat(driver.findElement(By.xpath("//span[@id='message-id']")).getText(), is("We have received your request"));
        driver.findElement(By.xpath("(//span[@class='a316'])[5]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Delete my account')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Cancel')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Contact us')]")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).click();
        driver.findElement(By.xpath("//input[@id='email-input']")).sendKeys("artyom99@bk.ru");
        driver.findElement(By.xpath("//input[@id='subject-input']")).click();
        driver.findElement(By.xpath("//input[@id='subject-input']")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[@name='textBox']")).click();
        driver.findElement(By.xpath("//textarea[@name='textBox']")).sendKeys("test12");
        driver.findElement(By.xpath("//input[@id='name-input']")).click();
        driver.findElement(By.xpath("//input[@id='name-input']")).sendKeys("test");
        driver.findElement(By.xpath("//div[contains(text(), 'I agree to the Answers ')]")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
