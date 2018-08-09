Feature: Tenant Manager Editing a Project Information 

@CRM-289-TC-01  @demo @smoke @regression
Scenario:Create a new Project
	Given I logged into Tenant Manager Project list page 
	When I click on Create a New Project
	Then I should be navigated to the Add Project Page

@CRM-289-TC-02 @demo @smoke @regression
Scenario:Validate all the Elements in the Project Contact Details
   Given I am on the Home Page
   When I click on the Create new Project
   Then I should see all the elements displayed in the Project Contact Page

@CRM-289-TC-03 @demo @smoke @regression
 Scenario: Create a new Project and save the Project
  Given I am on the Project Contact Details Page
   When I enter all the Details and save the Project
    Then I should be navigated to the Home Page


