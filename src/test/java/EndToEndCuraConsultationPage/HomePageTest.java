package EndToEndCuraConsultationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BeforeDoingTest {
    // Define XPath
    final By H1Homepage = By.xpath("//h1[contains(text(), 'VISITING A DOCTOR IS ONE TOUCH AWAY')]");
    final By ButtonSeeDoctor = By.xpath("//a[contains(text(),'See a Doctor')]");

    @Test(priority = 1)
    public void testHomePage() {
        driver.findElement(By.id("logo")).click();

        String ExpectedH1 = "VISITING A DOCTOR IS ONE TOUCH AWAY";
        String ActualH1 = driver.findElement(H1Homepage).getText();
        Assert.assertEquals(ExpectedH1, ActualH1);

        if (ExpectedH1.equals(ActualH1)) {
            System.out.println("H1 Match = " + ExpectedH1);
        } else {
            System.out.println("H1 NOT Match = " + ExpectedH1);
        }

        WebElement seeDoctorButton = driver.findElement(ButtonSeeDoctor);

        boolean isClickable = seeDoctorButton.isDisplayed() && seeDoctorButton.isEnabled();
        Assert.assertTrue(isClickable, "The 'See a Doctor' button is not clickable");

        driver.findElement(ButtonSeeDoctor).click();

    }
}
