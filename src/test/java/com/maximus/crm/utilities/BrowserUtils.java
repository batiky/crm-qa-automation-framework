package com.maximus.crm.utilities;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.maximus.crm.pages.LoginPage;
import com.maximus.crm.pages.ProjectDetailsPage;
import com.maximus.crm.pages.TenantManagerListOfProjectsPage;
import cucumber.api.java.et.Ja;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.base.Function;
import sun.java2d.pipe.SpanShapeRenderer;

public class BrowserUtils {

	LoginPage loginPage = new LoginPage();
	TenantManagerListOfProjectsPage tenantManagerListOfProjectsPage = new TenantManagerListOfProjectsPage();
	ProjectDetailsPage projectDetailsPage = new ProjectDetailsPage();
	Logger logger = Logger.getLogger(BrowserUtils.class);


	public static void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
		jse.executeScript("scroll(0, 250);");
	}

	public static List<String> getElementsText(By locator) {

		List<WebElement> elems = Driver.getDriver().findElements(locator);
		List<java.lang.String> elemTexts = new ArrayList<>();
		for (WebElement el : elems) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}

		return elemTexts;
	}

	public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForVisibility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickablility(WebElement element, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForClickablility(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement fluentWait(final WebElement webElement, int timeinsec) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
				.withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});
		return element;
	}

	public static void waitForPageToLoad(long timeOutInSeconds) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		try {
			System.out.println("Waiting for page to load...");
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println(
					"Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
		}
	}

	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void switchToWindow(String targetTitle) {
		String origin = Driver.getDriver().getWindowHandle();
		for (String handle : Driver.getDriver().getWindowHandles()) {
			Driver.getDriver().switchTo().window(handle);
			if (Driver.getDriver().getTitle().equals(targetTitle)) {
				return;
			}
		}
		Driver.getDriver().switchTo().window(origin);
	}

	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	}

	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemText = new ArrayList<>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemText.add(el.getText());
			}

		}
		return elemText;
	}

	/*
	 * This method is created by Shilpa
	 * */
	public void highLightElement(WebElement element) {
		staticWait(100);
		logger.info("Started Executing the Java Script ");
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red;');", element);
		try {
			Thread.sleep(1000);
			logger.info("Executed and HighLighted");
		} catch (InterruptedException e) {
			System.out.print(e.getMessage());
		}

	}

	public void clearAndFillText(WebElement element, String text) {
		element.clear();
		staticWait(500);
		element.sendKeys(text);
	}

/*
this is duplicate of line 102 <public static void wait(){}>/
 */
	public void staticWait(int timeInMilliSeconds) {
		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String randomEmailId() {
		String n = UUID.randomUUID().toString().substring(30);
		String s = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()).toString().replaceAll(":", "").
				replaceAll("", "").replaceAll("-", "").replace(".", "")
				.substring(2);
		String email = "test" + n + s + "@gmail.com";
		return email;
	}

	public void login(String userName, String password) {
		clearAndFillText(loginPage.userName, userName);
		clearAndFillText(loginPage.password, password);
		loginPage.submitButton.click();

	}
	public String getCurrentDateWithFormat(){
		Date currentDate=new Date();
		String DATE_FORMAT = "MMddyyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		String actualDate=sdf.format(currentDate);
		return actualDate;

	}

	public String getFutureYearWithCurrentdate(int year ){
		String DATE_FORMAT = "MMddyyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.YEAR,year);
		 return sdf.format(cal.getTime());

	}


	public void createAndSave(String projectName, String programName, String contractId, String clientName) {
		clearAndFillText(projectDetailsPage.projectName, projectName);
		projectDetailsPage.state.click();
		hover(projectDetailsPage.state);
		projectDetailsPage.AR.click();
		clearAndFillText(projectDetailsPage.programName, programName);
		clearAndFillText(projectDetailsPage.contractId, contractId);
		clearAndFillText(projectDetailsPage.stateAgencyName, clientName);
		projectDetailsPage.provisioningStatus.click();
		hover(projectDetailsPage.provisioningStatus);
		projectDetailsPage.activeStatus.click();
		System.out.print("Clicked");
		//staticWait(5000);
		hover(projectDetailsPage.saveButton);
		highLightElement(projectDetailsPage.saveButton);
		projectDetailsPage.saveButton.click();
		highLightElement(projectDetailsPage.saveButton);
	}

	public void addContractDateAndSaveCurrentDate(String projectName, String programName, String contractId, String clientName, String startDate) {
		clearAndFillText(projectDetailsPage.projectName, projectName);
		projectDetailsPage.state.click();
		hover(projectDetailsPage.state);
		projectDetailsPage.AR.click();
		clearAndFillText(projectDetailsPage.programName, programName);
		clearAndFillText(projectDetailsPage.contractId, contractId);
		clearAndFillText(projectDetailsPage.stateAgencyName, clientName);
		clearAndFillText(projectDetailsPage.contractStartDate, startDate);
		clearAndFillText(projectDetailsPage.contractEndDate, startDate);
		projectDetailsPage.provisioningStatus.click();
		hover(projectDetailsPage.provisioningStatus);
		projectDetailsPage.activeStatus.click();
		System.out.print("Clicked");
		//staticWait(5000);
		hover(projectDetailsPage.saveButton);
		highLightElement(projectDetailsPage.saveButton);
		projectDetailsPage.saveButton.click();
		highLightElement(projectDetailsPage.saveButton);
	}
	public void addContractDateAndSaveCurrentDateAndEndDate(String projectName, String programName, String contractId, String clientName, String startDate, String endDate) {
		clearAndFillText(projectDetailsPage.projectName, projectName);
		projectDetailsPage.state.click();
		hover(projectDetailsPage.state);
		projectDetailsPage.AR.click();
		clearAndFillText(projectDetailsPage.programName, programName);
		clearAndFillText(projectDetailsPage.contractId, contractId);
		clearAndFillText(projectDetailsPage.stateAgencyName, clientName);
		clearAndFillText(projectDetailsPage.contractStartDate, startDate);
		clearAndFillText(projectDetailsPage.contractEndDate, endDate);
		projectDetailsPage.provisioningStatus.click();
		hover(projectDetailsPage.provisioningStatus);
		projectDetailsPage.activeStatus.click();
		System.out.print("Clicked");
		//staticWait(5000);
		hover(projectDetailsPage.saveButton);
		highLightElement(projectDetailsPage.saveButton);
		projectDetailsPage.saveButton.click();
		highLightElement(projectDetailsPage.saveButton);
	}




}