package EndToEndCuraConsultationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookAppointmentPageTest extends HomePageTest {

    @Test(priority = 2)
    public void LoginHere() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        final By LoginHere = By.xpath("//a[contains(text(),'Log in Here')]");
        final By h1BookAppointment = By.xpath("//span[contains(text(),'Book An Appointment')]");

        String ActualtextH1 = driver.findElement(h1BookAppointment).getText();
        String ExpectedTextH1 = "Book An Appointment";
        Assert.assertEquals(ActualtextH1, ExpectedTextH1);

        boolean buttonLogInHere = driver.findElement(LoginHere).isDisplayed() && driver.findElement(h1BookAppointment).isEnabled();
        Assert.assertTrue(buttonLogInHere, "Button is not clickable");
        driver.findElement(LoginHere).click();
    }
}
