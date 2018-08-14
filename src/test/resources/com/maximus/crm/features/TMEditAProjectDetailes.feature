Feature: Tenant Manager Editing a Project Details

  @CRM-293 @regression
  Scenario Outline: Edit project details single field
    Given I logged into Tenant Manager Project list page
    When I expend a Project to view the details
      | projectNumber | <projectNumber> |
    And I edit and save the "Project Name" with "Child Benefit2"
  #    And I edit and save the "program_name" with "NY"
    #    And I edit and save the "state" with "DHMH"
    And I edit and save the "Contract_id" with "ZCB123"
    And I edit and save the "start_date" with "05062018"
    And I edit and save the "end_date" with "06092022"

    #    And I edit and save the "state" with "NY" for element "state"
    #    And I edit and save the "state" with "NY" for element "state"
    #    And I edit and save the "state" with "NY" for element "state"



  #      | program_name        | Child Benefit |
#      | state               | NY            |
#      | program_name        | DHMH          |
#      | contract_id         | ZCB123        |
#      | client_agency_name  | StateHelp     |
#      | start_date          | 05062018      |
#      | end_date            | 06092022      |
#      | provisioning_status | Active        |
    Then I should see the project details updated by example
    |Child Benefit, ZCB123, 05062018, 06092022|
#  [Child Benefit2, CA, ZCB123, 13, PENDING, Medicaid, Illonis State Agency, 05/06/2018, 06/09/2022]
#  [Child Benefit, ZCB123, 05062018, 06092022]
    And I edit all the project details at one step
    Examples:
      | projectNumber |
      | 0             |
#      | 1             |
#      | 2             |
#      | 3             |
#      | 4             |
#      | 5             |


  @CRM-293_24 @smoke
  Scenario: Not saving edited project details
    Given I logged into Tenant Manager Project list page
    When I expend a Project to view the details
    And I edit the project details one at the time without saving
      | project_name        | <programName>        |
      | state               | <state>              |
      | program_name        | <programName>        |
      | contract_id         | <contractId>         |
      | client_agency_name  | <clientAgensyName>   |
      | contract_start      | <contractStartDate>  |
      | contract_end        | <contractEndDate>    |
      | provisioning_status | <provisioningStatus> |
    Then I should not see the project details updated

  @CRM-293 @smoke
  Scenario: Edit project contact details
    Given I logged into Tenant Manager Project list page
    When I choose a project to view
    And I edit the project contact details
      | contact          |
      | account_manager  |
      | account_approval |
    Then I should see the project contact details updated

