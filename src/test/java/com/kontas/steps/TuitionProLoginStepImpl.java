package com.kontas.steps;

import org.openqa.selenium.WebDriver;

import com.kontas.pages.TuitionProMain;
import com.kontas.runners.TuitionProRunner;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TuitionProLoginStepImpl {

	public static TuitionProMain tuitionpromain=TuitionProRunner.tuitionpromain;
	public static WebDriver driver=TuitionProRunner.driver;
	
	
	@Given("^Julio Sanchez is on the TuitionPro Home Page$")
	public void julio_Sanchez_is_on_the_TuitionPro_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http:/localhost:8080/TuitionPro");
	}

	@When("^The guest enter \"([^\"]*)\"  in the name field$")
	public void the_guest_enter_in_the_name_field(String name) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		tuitionpromain.name.sendKeys(name);
	}

	@When("^The guest enter \"([^\"]*)\" in the surname field$")
	public void the_guest_enter_in_the_surname_field(String surname) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		tuitionpromain.name.sendKeys(surname);
	}

	@When("^The guest press the \"([^\"]*)\" button$")
	public void the_guest_press_the_button(String loginButtton) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		tuitionpromain.loginButton.click();;
	}

	@Then("^The guest should be on the Main Page$")
	public void the_guest_should_be_on_the_Main_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertEquals("Main Page",driver.getTitle());;
	}

	
}
