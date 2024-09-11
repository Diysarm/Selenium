package EndToEndCuraConsultationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CuraConsultPageTest extends BookAppointmentPageTest{
    //Data
    String DataFirstName = "Muhammad";
    String DataLastName = "Rasyid";
    String DataH3TitleExpected = "Cura Consultation Page";
    String DataPatientMRN = "000098283741";
    String DataFacilityName = "Medica dolor";
    String DataReasonForConsult = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in lacus vel magna dictum semper eget nec tellus. Vivamus ante nibh, tristique at tincidunt at, maximus ut erat. Nulla tempus a mauris nec mollis. Integer convallis odio metus, eu tincidunt elit maximus ac. Phasellus sodales auctor felis. Praesent pretium metus sit amet augue scelerisque efficitur. Nunc cursus a est eu ullamcorper. In eget diam eu velit viverra eleifend. Suspendisse a feugiat orci. Nunc in lacinia magna. Donec posuere euismod libero, in ultricies orci cursus in. Aenean fermentum pharetra velit a molestie. Fusce fermentum risus et est semper, ac suscipit sapien vestibulum. Vestibulum vestibulum auctor enim eget rhoncus. Pellentesque convallis lorem quis lorem porta facilisis. Etiam iaculis hendrerit nibh, sit amet vestibulum velit laoreet sed.";
    //locators
    final By FirstNameObject = By.id("input_1_4_3");
    final By LastNameObject = By.id("input_1_4_6");
    final By H3TitleObject = By.xpath("//h3[contains(text(),'Cura Consultation Page')]");
    final By DOBFieldObject = By.id("input_1_5");
    final By DatePickerUIObject = By.id("ui-datepicker-div");
    final By SelectDateDOB =  By.xpath("//a[@data-date='6']");
    final By GenderMale = By.id("choice_1_7_0");
    final By GenderFemale = By.id("choice_1_7_1");
    final By GenderNonBinary = By.id("choice_1_7_2");
    final By GenderUnknown = By.id("choice_1_7_3");
    final By PatientMRNObject = By.id("input_1_8");
    final By FacilityNameObject = By.id("input_1_11");
    final By ReasonForConsultObject = By.id("input_1_12");

    @Test(priority = 3)
    public void VerifyH3Title() {
        String DataH3TitleActual = driver.findElement(H3TitleObject).getText();
        Assert.assertEquals(DataH3TitleActual, DataH3TitleExpected);

    }
    @Test(priority = 3)
    public void InputFirstName() {
        driver.findElement(FirstNameObject).clear();
        driver.findElement(FirstNameObject).sendKeys(DataFirstName);
        String EnteredFirstname = driver.findElement(FirstNameObject).getAttribute("value");
        Assert.assertEquals(EnteredFirstname, DataFirstName);
    }
    @Test(priority = 3)
    public void InputLastName() {
        driver.findElement(LastNameObject).clear();
        driver.findElement(LastNameObject).sendKeys(DataLastName);
        String EnteredLastname = driver.findElement(LastNameObject).getAttribute("value");
        Assert.assertEquals(EnteredLastname, DataLastName);
    }
    @Test(priority = 3)
    public void InputDOBField() {

        driver.findElement(DOBFieldObject).click();
        driver.findElement(DatePickerUIObject).isDisplayed();
    }
    @Test(priority = 3)
    public void SelectMonthDropDown(){
            WebElement SelectMonthDOB = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
            WebElement SelectedOption = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']/option[@value='3']"));
            String SelectedMonth = SelectedOption.getText();

            Select SelectMonth = new Select(SelectMonthDOB);
            SelectMonth.selectByValue("3");

            if(SelectedMonth.equals("April")){
                System.out.println("Bulan sudah sesuai = " + SelectedMonth);
            }else{
                System.out.println("Bulan belum sesuai = " + SelectedMonth);
            }
        }

    @Test(priority = 3)
    public void SelectYearDropDown() {
        WebElement SelectYearDOB = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        WebElement SelectedOption = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']/option[@value='1994']"));
        String SelectedYear = SelectedOption.getText();

        Select SelectYear = new Select(SelectYearDOB);
        SelectYear.selectByValue("1994");

        if (SelectedYear.equals("1994")) {
            System.out.println("Tahun sudah sesuai = " + SelectedYear);
        } else {
            System.out.println("Tahun belum sesuai = " + SelectedYear);
        }

        }
    @Test(priority = 4)
    public void SelectDatePicker() {
        driver.findElement(SelectDateDOB).isDisplayed();
        driver.findElement(SelectDateDOB).isEnabled();
        driver.findElement(SelectDateDOB).click();

    }
    @Test(priority = 4)
    public void VerifyDOB() {
        String hasilDOB = driver.findElement(DOBFieldObject).getAttribute("value");
        if(hasilDOB.equals("04/06/1994")){
        System.out.println("DOB Match = " + hasilDOB);
        }else{
            System.out.println("DOB Not Match = " + hasilDOB);
        }
    }
    @Test(priority = 5)
    public void SelectGender() {
        if(!driver.findElement(GenderMale).isSelected() &&
           !driver.findElement(GenderFemale).isSelected() &&
           !driver.findElement(GenderNonBinary).isSelected() &&
           !driver.findElement(GenderUnknown).isSelected())
        {
            System.out.println("Gender is not picked");
            driver.findElement(GenderMale).click();
        }else{
            System.out.println("Gender is selected");
        }
        if(driver.findElement(GenderMale).isSelected() &&
           !driver.findElement(GenderFemale).isSelected() &&
           !driver.findElement(GenderNonBinary).isSelected() &&
           !driver.findElement(GenderUnknown).isSelected())
        {
            System.out.println("Gender Male is picked");
        } else {
            System.out.println("Other than Male is picked");
        }
    }
    @Test(priority = 5)
    public void InputPatientMRN(){
        driver.findElement(PatientMRNObject).isDisplayed();
        driver.findElement(PatientMRNObject).sendKeys(DataPatientMRN);
        String ActualPatientMRNData = driver.findElement(PatientMRNObject).getAttribute("value");
        if(ActualPatientMRNData.equals(DataPatientMRN)){
            System.out.println("Data Patient Match : " + ActualPatientMRNData);
        }else{
            System.out.println("Data Patient Not Match : " + ActualPatientMRNData);
        }
    }
    @Test(priority = 6)
    public void InputFacilityName(){
        driver.findElement(FacilityNameObject).isDisplayed();
        driver.findElement(FacilityNameObject).sendKeys(DataFacilityName);
        String ActualFacilityName = driver.findElement(FacilityNameObject).getAttribute("value");
        if(ActualFacilityName.equals(DataPatientMRN)){
            System.out.println("Data Facility Match : " + ActualFacilityName);
        }else{
            System.out.println("Data Facility Not Match : " + ActualFacilityName);
        }
    }
    @Test (priority = 6)
    public void InputReasonForConsult(){
        driver.findElement(ReasonForConsultObject).isDisplayed();
        driver.findElement(ReasonForConsultObject).sendKeys(DataReasonForConsult);
        String ActualReasonForConsult = driver.findElement(ReasonForConsultObject).getAttribute("value");
        if(ActualReasonForConsult.equals(DataReasonForConsult)){
            System.out.println("Data Reason For Consult Match : " + ActualReasonForConsult);
        }else{
            System.out.println("Data Reason For Consult Not Match : " + ActualReasonForConsult);
        }
    }
    @Test(priority = 6)
    public void UploadFiles(){
        /*
        WebElement ButtonSelectFiles = driver.findElement(By.id("gform_browse_button_1_13"));
        ButtonSelectFiles.isDisplayed();
        ButtonSelectFiles.isEnabled();
        ButtonSelectFiles.click();
        */

        WebElement InputFile = driver.findElement(By.xpath("//input[@type='file']"));
        if(InputFile.isEnabled() && InputFile.isDisplayed()) {
            InputFile.sendKeys("C:\\Users\\rasyid\\IdeaProjects\\Selenium\\SUBCLASS - College of Piracy v1.0.pdf");
            System.out.println("Upload File Successfully");
        }else{
            System.out.println("Upload File Failed");
        }
        }
    }
