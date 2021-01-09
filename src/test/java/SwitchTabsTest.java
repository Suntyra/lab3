import helpers.WebdriverSettings;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SwitchTabsTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = WebdriverSettings.getDriver();
    }

    @Test
    public void testTrendingTabs() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//span[contains(text(), 'best')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/best"));
        driver.findElement(By.xpath("//span[contains(text(), 'trending')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/trending"));
        driver.findElement(By.xpath("//span[contains(text(), 'hot')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/hot"));
        driver.quit();
    }

    @Test
    public void testNavigationTabs() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.answers.com/");
        driver.manage().window().setSize(new Dimension(1200, 1200));
        driver.findElement(By.xpath("//a[contains(text(), 'Science')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/t/science"));
        driver.findElement(By.xpath("//a[contains(text(), 'Math')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/t/math-and-arithmetic"));
        driver.findElement(By.xpath("//a[contains(text(), 'History')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/t/history"));
        driver.findElement(By.xpath("//a[contains(text(), 'Literature')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/t/literature-and-language"));
        driver.findElement(By.xpath("//a[contains(text(), 'Technology')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/t/technology"));
        driver.findElement(By.xpath("//a[contains(text(), 'Health')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/t/health"));
        driver.findElement(By.xpath("//a[contains(text(), 'Law')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/t/law-and-legal-issues"));
        driver.findElement(By.xpath("//a[contains(text(), 'Business')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/t/business-and-finance"));
        driver.findElement(By.xpath("//a[contains(text(), 'All Topics')]")).click();
        assertThat(driver.getCurrentUrl(), is("https://www.answers.com/topics"));
        driver.findElement(By.xpath("//a[contains(text(), 'Random')]")).click();
        driver.quit();
    }
}
