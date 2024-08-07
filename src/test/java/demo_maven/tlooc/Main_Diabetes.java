package demo_maven.tlooc;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;

public class Main_Diabetes {
	
	private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;
	public static void main(String[] args) {
		extent = ExtentReport_Diabetes.getExtentReports();
//		runReadMoreTest();
//		runMemberTest();
		runPatientInformationTest();
		extent.flush();
	}
	public static void navigateToWebsite() {
        driver.get("https://letanloctlooc.pythonanywhere.com/");
        test.pass("Navigated to letanloctlooc.pythonanywhere.com");
    }
	public static void runReadMoreTest() {
        test = extent.createTest("Access 'Đọc thêm' section", "Test accessing the 'Đọc thêm' section on the website");
        driver = new FirefoxDriver();
        test.log(Status.INFO, "Starting the browser and navigating to the website for 'Đọc thêm' section");
        try {
            navigateToWebsite();
            //clickReadMoreLink();
            WebElement readMoreLink = driver.findElement(By.linkText("Đọc thêm"));
            readMoreLink.click();
            test.pass("/html/body/section[1]/div/div/button/a");
            
        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
        } finally {
            try {
                Thread.sleep(5000); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
            test.pass("Closed the browser for 'Đọc thêm' section");
            test.info("Test Completed");
        }
    }
	
    public static void runMemberTest() {
        test = extent.createTest("Access 'THÀNH VIÊN' section", "Test accessing the 'THÀNH VIÊN' section on the website");
        driver = new FirefoxDriver();
        test.log(Status.INFO, "Starting the browser and navigating to the website for 'THÀNH VIÊN' section");
        try {
            navigateToWebsite();
            //clickMember();
            WebElement memberClck = driver.findElement(By.linkText("THÀNH VIÊN"));
        	memberClck.click();
        	test.pass("/html/body/header/div/nav/ul/li[4]/a");
        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
        } finally {
            try {
                Thread.sleep(5000); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
            test.pass("Closed the browser for 'THÀNH VIÊN' section");
            test.info("Test Completed");
            }
        }
    public static void fillPatientInformationForm(String name, String age, String gender, String phoneNumber) {
        WebElement nameField = driver.findElement(By.name("full_name"));
        WebElement ageField = driver.findElement(By.name("age"));
        WebElement phoneField = driver.findElement(By.name("phone_number"));

        nameField.sendKeys(name);
        ageField.sendKeys(age);
        phoneField.sendKeys(phoneNumber);

        if (gender.equalsIgnoreCase("Male")) {
            WebElement genderMale = driver.findElement(By.id("male"));
            genderMale.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            WebElement genderFemale = driver.findElement(By.id("female"));
            genderFemale.click();
        }

        test.pass("Filled out the form with name: " + name + ", age: " + age + ", gender: " + gender + ", phone number: " + phoneNumber);

        WebElement submitButton = driver.findElement(By.name("xacnhan"));
        submitButton.submit();;
        test.pass("//*[@id=\"xacnhan\"]");
        
//        try {
//            // Find the submit button using its text
//            WebElement submitButton = driver.findElement(By.xpath("button[text()='Xác nhận']"));
//            submitButton.click();
//            test.pass("/html/body/section[3]/div/form/button");
//        } catch (Exception e) {
//            test.fail("Clicking submit button failed with exception: " + e.getMessage());
//            // Fallback: Use JavaScript to submit the form
//            WebElement form = driver.findElement(By.tagName("form"));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].submit();", form);
//            test.pass("Form submitted using JavaScript");
//        }
    }
    public static void runPatientInformationTest() {
        test = extent.createTest("Access Patient Information", "Test accessing the Patient Information section on the website");
        driver = new FirefoxDriver();
        test.log(Status.INFO, "Starting the browser and navigating to the Patient Information section");
        try {
        	navigateToWebsite();
        	WebElement patienInfoClck = driver.findElement(By.linkText("CHẨN ĐOÁN"));
        	patienInfoClck.click();
        	test.pass("/html/body/header/div/nav/ul/li[2]/a");
            fillPatientInformationForm("Nguyen Van A", "30", "male", "0123456789");
        } catch (Exception e) {
            test.fail("Test failed with exception: " + e.getMessage());
        } finally {
            try {
                Thread.sleep(5000); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
            test.pass("Closed the browser for Patient Information section");
            test.info("Test Completed");
        }
    }
}