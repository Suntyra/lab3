import helpers.WebdriverSettings;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class ShowAndAddCommentsTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebdriverSettings.getDriver();
    }

    @Test
    public void testShowComments() throws InterruptedException {
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
        driver.findElement(By.xpath("//span[contains(text(), 'Answer')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Close')]")).click();
        driver.findElement(By.xpath("(//button[contains(text(), 'View Comments')])[1]")).click();
        assertThat(driver.findElement(By.xpath("(//button[contains(text(), 'Hide Comments')])[1]")).getText(), containsString("Hide"));
        driver.findElement(By.xpath("(//button[contains(text(), 'Hide Comments')])[1]")).click();
        assertThat(driver.findElement(By.xpath("(//button[contains(text(), 'View Comments')])[1]")).getText(), containsString("View"));
        driver.quit();
    }

    @Test
    public void testAddComment() throws InterruptedException {
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
        driver.findElement(By.xpath("//span[contains(text(), 'Answer')]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Close')]")).click();
        driver.findElement(By.xpath("(//button[contains(text(), 'View Comments')])[1]")).click();
        driver.findElement(By.xpath("//div[@id = 'comment-input-box']")).click();
        driver.findElement(By.xpath("//div[@id = 'comment-input-box']")).sendKeys("test comment");
        driver.findElement(By.xpath("(//button)[9]")).click();
        assertThat(driver.findElement(By.xpath("//div[contains(text(), 'test comment')]")).getText(), is("test comment"));
        driver.quit();
    }
}
