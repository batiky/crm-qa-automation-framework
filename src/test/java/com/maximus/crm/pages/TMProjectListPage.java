package com.maximus.crm.pages;

import com.maximus.crm.utilities.BrowserUtils;
import com.maximus.crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.maximus.crm.utilities.BrowserUtils.waitForClickablility;
import static com.maximus.crm.utilities.BrowserUtils.waitForPageToLoad;

public class TMProjectListPage {

    private WebDriver driver;
    private BrowserUtils browserUtils = new BrowserUtils();

    public TMProjectListPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//label[starts-with(text(), 'State')]/..//input ")
    public WebElement searchByState;

    @FindBy(xpath="//label[starts-with(text(), 'Project')]/..//input")
    public WebElement searchProject;

    @FindBy(xpath="//label[starts-with(text(), 'Program')]/..//input ")
    public WebElement searchByProgram;

    @FindBy(xpath="//label[starts-with(text(), 'Client/State Agency')]/..//input")
    public WebElement searchByClientStateAgency;

    @FindBy(xpath ="//span[contains(text(), ' Search ')]" )
    public WebElement search;

    @FindBy(xpath ="//span[contains(text(), ' Clear ')]" )
    public WebElement clear;

    @FindAll({
            @FindBy(css = ".row.mx-0 > div")
    })
    public List<WebElement> projects;       //List<WebElement> projects  = driver.findElements(By.cssSelector(".row.mx-0 > div"));

    @FindBy(xpath = "//*[@id='root']//h4")
    public WebElement projectListDashboard;

    public static String expendButtonClass = "jss72";
    public static String projectNameCSS = "h4";
    public static String projectStateClass = "pr-2";
    public static String contractIdClass = "pl-2";
    public static String projectIdCSS = "h6";
    public static String provisioningStatusXpath = "//h6/span[@class]";
    public static String programNameXpath = "(//div/p[@class='mt-0 mdl-color-text--grey-700 lead'])[1]";
    public static String clientNameXpath = "(//div/p[@class='mt-0 mdl-color-text--grey-700 lead'])[2]";
    public static String startDateXpath = "(//div/p[@class='mt-0 mdl-color-text--grey-700 lead'])[3]";
    public static String endDateXpath = "(//div/p[@class='mt-0 mdl-color-text--grey-700 lead'])[4]";

    public static void expendProject(WebElement element) {
        element.findElement(By.className(expendButtonClass)).click();
    }

    public void search (){
      // waitForPageToLoad(5000).search.click();

    }


    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public List<String> projectInfo(int projNum) {
        List<String> projectInfoText = new ArrayList<>();

        WebElement currentProject = projects.get(projNum);
        scrollIntoView(currentProject);
        projectInfoText.add(currentProject.findElement(By.cssSelector(projectNameCSS)).getText());
        projectInfoText.add(currentProject.findElement(By.className(projectStateClass)).getText());
        projectInfoText.add(currentProject.findElement(By.className(contractIdClass)).getText());
        String projectId = currentProject.findElement(By.cssSelector(projectIdCSS)).getText();
        projectInfoText.add(projectId.substring(0, projectId.indexOf(" ")));
        projectInfoText.add(currentProject.findElement(By.xpath(provisioningStatusXpath)).getText());
        projectInfoText.add(currentProject.findElement(By.xpath(programNameXpath)).getText());
        projectInfoText.add(currentProject.findElement(By.xpath(clientNameXpath)).getText());
        projectInfoText.add(currentProject.findElement(By.xpath(startDateXpath)).getText());
        projectInfoText.add(currentProject.findElement(By.xpath(endDateXpath)).getText());
        return projectInfoText;
    }
}
