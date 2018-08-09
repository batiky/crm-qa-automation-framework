package com.maximus.crm.pages;

import com.maximus.crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectDetailsPage {

    private WebDriver driver;

    public ProjectDetailsPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//h4[contains(text(),'ADD PROJECT')]")
    public WebElement addProjectLogo;

    @FindBy(name = "projectName")
    public WebElement projectName;

    @FindBy(xpath="//*[@id='root']/div/main/div/div/div/div[2]/div/div[4]/div/div/div/div")
    public WebElement state;

    public WebElement stateName(int i){
       return  driver.findElement(By.xpath("//*[@id='menu-state']/div[2]/ul/li["+i +"])"));
    }
    @FindBy(xpath = "//*[@id='menu-state']/div[2]/ul/li[2]")
    public WebElement AR;

    @FindBy(name = "programName")
    public WebElement programName;

    @FindBy(name="contractId")
    public WebElement contractId;

    @FindBy(name="stateAgencyName")
    public WebElement stateAgencyName;

    @FindBy(xpath="//*[@id='root']/div/main/div/div/div/div[2]/div/div[8]/div/div/input")
    public WebElement contractStartDate;

    @FindBy(xpath = "//*[@id='root']/div/main/div/div/div/div[2]/div/div[9]/div/div/input")
    public WebElement contractEndDate;

    @FindBy(xpath="//div[contains(text(),'Pending')]")
    public WebElement  provisioningStatus;

    @FindBy(xpath ="//*[@id='menu-provStatus']/div[2]/ul/li[2]")
    public WebElement activeStatus;

    @FindBy(xpath="//button[contains(@class, 'mx-btn-border mx-btn-primary')]/span[1]")
    public WebElement saveButton;





}
