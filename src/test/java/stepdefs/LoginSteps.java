package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = BaseClass.driver;

	@Given("user has launched the swaglabs application")
	public void user_has_launched_the_swaglabs_application() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.saucedemo.com/");
	}

	@When("I enter username {string}")
	public void i_enter_username (String UserNameVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
		userName.sendKeys(UserNameVal);
	}

	@When("I enter password {string}")
	public void i_enter_password (String Password) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement userPwd = driver.findElement(By.xpath("//input[@id='password']"));
		userPwd.sendKeys(Password);
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions

		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginBtn.click();
	}

	@Then("I should be landed on Products page")
	public void i_should_be_landed_on_products_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement eleProd = driver.findElement(By.xpath("//span[@class='title']"));
		Assert.assertNotNull(eleProd);
	}

	@Then("I should see error message {string}")
	public void i_should_see_error_message(String ExpMsg) {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement ErrorMsg = driver.findElement(By.xpath("//h3[contains(text(),\"Epic sadface: Username and password do not match any user in this service\")]"));
	    
	    String ActualMsg = ErrorMsg.getText();
	    
	    Assert.assertEquals(ExpMsg, ActualMsg);
	}


}
