package stepdefs;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class ProductsSteps {
	
	WebDriver driver = BaseClass.driver;
	
	@Then("product price should be as per the below table")
	public void product_price_should_be_as_per_the_below_table(Map<String, String> productList) {
		for(String key: productList.keySet()) {
			WebElement eleProdName = driver.findElement(By.xpath("//div[contains(text(),'"+key+"')]"));
			if(eleProdName.isDisplayed()) {
				System.out.println("Actual product name : " +eleProdName.getText());
			    
			    String ExpectedProdVal = productList.get(key);
			    System.out.println("Expected product val : " +ExpectedProdVal);
			    WebElement eleProdVal = driver.findElement(By.xpath("//div[text()='"+key+"']/following::div[3]"));
			    String ActualProdVal = eleProdVal.getText();
			    System.out.println("Actual product val : " +ActualProdVal);
			    Assert.assertEquals(ExpectedProdVal, ActualProdVal);
			}
			
		}
	}


}
