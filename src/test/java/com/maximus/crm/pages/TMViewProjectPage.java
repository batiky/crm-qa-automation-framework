package com.maximus.crm.pages;

import com.maximus.crm.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TMViewProjectPage {

    private WebDriver driver;

    public TMViewProjectPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='root']//h4")
    public WebElement viewProjectDashboard;

    @FindBy(name = "projectName")
    public WebElement editProjectName;

    @FindBy (xpath = "//*[@id='state']/..")
    public WebElement state;

    @FindBy(name = "programName")
    public WebElement editProgramName;

    @FindBy(name = "contractId")
    public WebElement editContractId;

    @FindBy(name = "stateAgencyName")
    public WebElement editStateAgencyName;

    @FindBy(xpath = "//*[contains(text(), 'Contract Start Date')]/..//input")
    public WebElement editStartDate;

    @FindBy(xpath = "//*[contains(text(), 'Contract End Date')]/..//input")
    public WebElement editEndDate;

    @FindBy(xpath = "//input[@name='provStatus']")
    public WebElement editProvStatus;

    @FindBy (xpath = "//*[@class='jss72']/span/..")
    public WebElement saveButton;

}
