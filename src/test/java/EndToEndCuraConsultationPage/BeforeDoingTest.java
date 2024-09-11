package EndToEndCuraConsultationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BeforeDoingTest {

    WebDriver driver;
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rasyid\\IdeaProjects\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cura.com/demo-home-health/");
        driver.manage().window().maximize();
    }
}
