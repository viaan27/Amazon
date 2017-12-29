Feature: EndToEnd

Scenario: Amazon- capturing Number of item quantity

Given I am in home page
When I click on search textbox and enter the product name
And I click on search button
And I Select product quantity
And I click on Add to cart button
Then I should see product quantity in basket