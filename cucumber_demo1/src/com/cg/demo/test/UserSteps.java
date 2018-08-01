package com.cg.demo.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.cg.demo.cucumber.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserSteps {
	WebDriver driver;
	String str, str1;

	@Given("^login link and sign in$")
	public void login_link_and_sign_in() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Users\\ADM-IG-HWDLAB1F\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("D:\\153127_SravaniLingam\\cucumber_demo1\\src\\com\\cg\\demo\\test\\login.html");
		/*
		 * WebElement imagesLink = driver.findElements(By.linkText("Sign in")).get(0);
		 * imagesLink.click();
		 */
	}

	@When("^username is \"([^\"]*)\"$")
	public void username_is(String arg1) throws Throwable {
		driver.findElement(By.id("name")).sendKeys(arg1);
		str = arg1;
	}

	@When("^password \"([^\"]*)\"$")
	public void password(String arg1) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(arg1);
		str1 = arg1;
	}

	@Then("^login successfully$")
	public void login_successfully() throws Throwable {

		driver.findElement(By.id("submit")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		assertEquals("Successful Login",alert.getText());

	}

	/*
	 * @When("^password1 \"([^\"]*)\"$") public void password1(String arg1) throws
	 * Throwable { driver.findElement(By.id("password")).sendKeys(arg1); str1=arg1;
	 * }
	 */
	@Then("^invalid password$")
	public void invalid_password() throws Throwable {
		driver.findElement(By.id("submit")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		assertEquals("Invalid Password",alert.getText());
		// driver.findElement(By.xpath("//*[@id=\"js-flash-container\"]/div/div")).click();
	}

	@Then("^invalid login details$")
	public void invalid_login_details() throws Throwable {
		driver.findElement(By.id("submit")).click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		assertEquals("Username Incorrect",alert.getText());
	}
}
