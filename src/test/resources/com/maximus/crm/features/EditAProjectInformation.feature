Feature: Tenant Manager Editing a Project Information 

@CRM-293 @smoke @regression 
Scenario: Edit project detailes 
	Given I logged into Tenant Manager Project list page 
	When I choose a project to view 
	And I edit the project detailes 
		|project_name|East-West1|
		|state|NC|
		|program_name| ChildClinic|
		|contract_id|ng123|
		|client_agency_name| PennHelp|
		|contract_start| 05/02/2010|
		|contract_end|05/01/2021|
		|provisioning_status|Active|
	Then I should see the project detailes updated 
	
@CRM-293 @smoke @regression 
Scenario: Edit project contact detailes 
	Given I logged into Tenant Manager Project list page 
	When I choose a project to view 
	And I edit the project contact detailes 
		|contact|
		|account_manager|
		|account_approval|
	Then I should see the project contact detailes updated