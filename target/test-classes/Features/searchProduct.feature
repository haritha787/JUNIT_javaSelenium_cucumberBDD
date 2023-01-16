#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Search and Place order for products
  @SearchOffer
  Scenario Outline: Search usage for product search in both home and offers page
    Given User is on Greenkart landing page
    When User searched with product shortname <Name> and extracted actual name of the product
    Then User searched for same product shortname <Name> in offers page and check if the product exists
    
   Examples:
   | Name     |
   | TOM      |
   | BEET     |
   | Str      |
   

