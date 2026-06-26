package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import Hooks.Hooks;
import POM.JpetShoppingPage;

public class JpetSteps {
	static WebDriver driver=Hooks.driver;
	static JavascriptExecutor js;
	
	@Given("user is on jpet store sign in page")
	public void user_is_on_jpet_store_sign_in_page() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("user enters valid pavan77 and pavan123")
	public void user_enters_valid_pavan77_and_pavan123() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("pavan77");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("pavan123");
		
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}

	@Then("user should login successfully")
	public void user_should_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		boolean status=Objects.requireNonNull(driver.getPageSource()).contains("Welcome");
		if(!status) {
			throw new RuntimeException("Login Failed");
		}
	}

	@Then("user should select category")
	public void user_should_select_category() {
	    // Write code here that turns the phrase above into concrete actions
		JpetShoppingPage page=new JpetShoppingPage(driver);
		page.clickOnDogs();
	}

	@Then("user should select breed")
	public void user_should_select_breed() {
	    // Write code here that turns the phrase above into concrete actions
		JpetShoppingPage page=new JpetShoppingPage(driver);
		page.clickOnBreed();
	}

	@Then("user select add to cart")
	public void user_select_add_to_cart() {
	    // Write code here that turns the phrase above into concrete actions
		JpetShoppingPage page=new JpetShoppingPage(driver);
		page.clickOnAddToCart();
	}

	@Then("user should procees to check out")
	public void user_should_procees_to_check_out() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		JpetShoppingPage page=new JpetShoppingPage(driver);
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		page.clickOnProceedToCheckout();
		
	}

	@Then("user should continue and confirm the order")
	public void user_should_continue_and_confirm_the_order() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		JpetShoppingPage page=new JpetShoppingPage(driver);
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		page.clickContinue();
		
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(3000);
		page.clickConfirm();
		Thread.sleep(3000);
	}
}
