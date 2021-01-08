import helpers.WebdriverSettings;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AskQuestionTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebdriverSettings.getDriver();
    }

    @Test
    public void testAskQuestions() throws InterruptedException {
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
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(), 'Ask Question')]")).click();
        driver.findElement(By.xpath("//textarea")).sendKeys("When will 2020 end?");
        driver.findElement(By.xpath("//span[contains(text(), 'Advanced')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea[contains(@placeholder, '65-pound')]")).click();
        driver.findElement(By.xpath("//textarea[contains(@placeholder, '65-pound')]")).sendKeys("this problem torments me for a whole year");
        driver.findElement(By.xpath("(//input[@name = 'q'])[2]")).click();
        driver.findElement(By.xpath("(//input[@name = 'q'])[2]")).sendKeys("2020");
        driver.findElement(By.xpath("//span[contains(text(), 'Submit')]")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.xpath("//h3[contains(text(), 'When will 2020 end')]")).getText(), is("When will 2020 end?"));
        //assertThat(driver.findElement(By.xpath("//a[contains(text(), 'When will 2020 end')]")).getText(), is("When will 2020 end?"));
        driver.quit();
    }
}

