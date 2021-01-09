import helpers.WebdriverSettings;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebdriverSettings.getDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.answers.com/");
        driver.findElement(By.xpath("//input[@name='q']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Shrek");
        driver.findElement(By.xpath("//input[@name='q']")).submit();
        assertThat(driver.findElement(By.xpath("//span[contains(text(), 'Shrek')]")).getText(), is("Shrek"));
        driver.quit();
    }
}
