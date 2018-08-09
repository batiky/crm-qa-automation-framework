package com.maximus.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.maximus.crm.utilities.Driver;

public class TenantManagerListOfProjectsPage {

	private WebDriver driver;

    public TenantManagerListOfProjectsPage() {
    	this.driver = Driver.getDriver();
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath="//i[contains(text(),'add')]")
    public WebElement createProjectButton;

    @FindBy(xpath="//h4[contains(text(),'PROJECT LIST')]")
    public WebElement projectList;

}
