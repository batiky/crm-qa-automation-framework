Feature: Tenant Manager Search a Project

  @CRM-294-01 @regression
  Scenario: Invalid State name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "state" value "QB"
    Then I should see "No record found" message


  @CRM-294-02 @regression
  Scenario: Invalid Project name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "project" value "Invalid"
    Then I should see "No record found" message


  @CRM-294-03 @regression
  Scenario: Invalid Program name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "program" value "NotExisting"
    Then I should see "No record found" message

  @CRM-294-04 @regression
  Scenario: Invalid value ClientAgency search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "client" value "NoAgensy"
    Then I should see "No record found" message

  @CRM-294-05 @regression
  Scenario: Valid State name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "state" value "NY"
    Then I should see all projects with "state" value "NY"

  @CRM-294-06 @regression
  Scenario: Valid Project name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "project" value "test"
    Then I should see all projects with "project" value "Test"

  @CRM-294-07 @regression
  Scenario: Valid Program name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "program" value "test program"
    Then I should see all projects with "program" value "Test Program"

  @CRM-294-08 @regression
  Scenario: Valid Client/Agency name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "client" value "Colorado"
    Then I should see all projects with "Client-Agency" value "Colorado"

  @CRM-294-09 @regression
  Scenario: Project name Wild card search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "project" value "W"
    Then I should see the projects according to "project" "W" wild card

  @CRM-294-10 @regression
  Scenario: Wild card search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "state" value "C"
    Then I should see the projects according to "state" "C" wild card

  @CRM-294-11 @regression
  Scenario: Program name Wild card search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "program" value "Me"
    Then I should see the projects according to "program" "Me" wild card

  @CRM-294-12 @regression
  Scenario: ClientAgency Wild card search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "client" value "b"
    Then I should see the projects according to "client" "b" wild card

  @CRM-294-13 @regression
  Scenario: No value provided search
    Given I logged into Tenant Manager Project list page
    When I search for a project with empty search fields
    Then I should see "Please provide search criteria" message


  @CRM-294-14 @regression
  Scenario: Autocomplete Project name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "project" value "N"
    Then I should see potential "project" with "N" autocomplete
    And I should see all projects with "project" value "N"

  @CRM-294-15 @regression
  Scenario: Autocomplete Program name search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "program" value "r"
    Then I should see potential "program" with "r" autocomplete
    And I should see all projects with "program" value "r"

  @CRM-294-16 @regression
  Scenario: Autocomplete State search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "state" value "m"
    Then I should see potential "state" with "m" autocomplete
    And I should see all projects with "state" value "m"


  @CRM-294-16 @regression
  Scenario: Autocomplete Client/State Agency search
    Given I logged into Tenant Manager Project list page
    When I search for a project by "client" value "v"
    Then I should see potential "client" with "v" autocomplete
    And I should see all projects with "client" value "v"