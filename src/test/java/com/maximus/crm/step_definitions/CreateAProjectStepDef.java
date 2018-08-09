package com.maximus.crm.step_definitions;

import com.maximus.crm.pages.ProjectDetailsPage;
import com.maximus.crm.pages.TenantManagerListOfProjectsPage;
import com.maximus.crm.utilities.BrowserUtils;
import com.maximus.crm.utilities.ConfigurationReader;
import com.maximus.crm.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateAProjectStepDef extends BrowserUtils {

    private WebDriver driver= Driver.getDriver();
    BrowserUtils browserUtils=new BrowserUtils();
    ProjectDetailsPage projectDetailsPage=new ProjectDetailsPage();
    TenantManagerListOfProjectsPage tenantManagerListOfProjectsPage=new TenantManagerListOfProjectsPage();

    public String userNamedata = ConfigurationReader.getProperty("tenantManagerLogin");
    public String password = ConfigurationReader.getProperty("tenatManagerPassword");
    public String projectName = ConfigurationReader.getProperty("projectName");
    public String programName=ConfigurationReader.getProperty("programName");
    public String contractId=ConfigurationReader.getProperty("contractId");
    public String clientAgency=ConfigurationReader.getProperty("stateAgencyName");


    @Given("I logged into Tenant Manager Project list page")
    public void i_logged_into_Tenant_Manager_Project_list_page(){
        driver.get(ConfigurationReader.getProperty("tenantManagerPageURL"));
        browserUtils.login(userNamedata,password);
    }

    @When("I click on Create a New Project")
    public void i_click_on_create_a_new_project(){
        highLightElement(tenantManagerListOfProjectsPage.createProjectButton);
        staticWait(100);
        tenantManagerListOfProjectsPage.createProjectButton.click();

    }

    @Then("I should be navigated to the Add Project Page")
    public void i_should_be_navigated_to_the_add_project_page(){
        Assert.assertTrue(projectDetailsPage.addProjectLogo.isDisplayed());
        highLightElement(projectDetailsPage.addProjectLogo);

    }


    @Given("I am on the Home Page")
    public void i_am_on_the_home_page(){
        i_logged_into_Tenant_Manager_Project_list_page();

    }

    @When("I click on the Create new Project")
    public void i_click_on_the_create_new_project(){

        i_click_on_create_a_new_project();
    }

    @Then("I should see all the elements displayed in the Project Contact Page")
    public void i_should_see_all_the_elements_displayed_in_the_project_contact_page(){
        staticWait(100);
        Assert.assertTrue(projectDetailsPage.addProjectLogo.isDisplayed());
        Assert.assertTrue(projectDetailsPage.projectName.isDisplayed());
        Assert.assertTrue(projectDetailsPage.state.isDisplayed());
        Assert.assertTrue(projectDetailsPage.programName.isDisplayed());
        Assert.assertTrue(projectDetailsPage.contractId.isDisplayed());
        Assert.assertTrue(projectDetailsPage.stateAgencyName.isDisplayed());
        Assert.assertTrue(projectDetailsPage.contractStartDate.isDisplayed());
        Assert.assertTrue(projectDetailsPage.contractEndDate.isDisplayed());
        Assert.assertTrue(projectDetailsPage.provisioningStatus.isDisplayed());
        Assert.assertTrue(projectDetailsPage.saveButton.isDisplayed());

    }


    @Given("I am on the Project Contact Details Page")
    public void i_am_on_the_project_contact_details_page(){
        i_logged_into_Tenant_Manager_Project_list_page();
        i_click_on_create_a_new_project();

    }

    @When("I enter all the Details and save the Project")
    public void i_enter_all_the_details_and_save_the_project(){
        staticWait(100);
        browserUtils.createAndSave(projectName,programName,contractId,clientAgency);

    }

    @Then("I should be navigated to the Home Page")
    public void i_should_be_navigated_to_the_home_page(){
        Assert.assertTrue(tenantManagerListOfProjectsPage.projectList.isDisplayed());
        highLightElement(tenantManagerListOfProjectsPage.projectList);

    }





}
