Feature: Registerpage testing with different sets of data

Scenario: Registerpage-using datatable

Given I am in Tuclothing home page
And I click on login/register link
When I click on register button
And I enter all the details regarding registration
|Email address|Title|First name|Surname|Password|Confirm Password|
|sru4366tu@gmail.com|Mrs|ghdtsxa|rvhgvthh|344ghiih2|344ghiih2|
And I click on terms and conditions button
Then I click on complete registration button
And I should see welcome page

@scenario
Scenario Outline: Registerpage-using scenario outline

Given I am in Tuclothing home page
And I click on login/register link
When I click on register button
And I enter details of "<Email address>" , "<Title>" , "<First name>" , "<Surname>" , "<Password>" and "<Confirm Password>"
And I click on terms and conditions button
Then I click on complete registration button
And I should see welcome page

Examples:
|Email address|Title|First name|Surname|Password|Confirm Password|
|srhgvhgj@gmail.com|Mrs|Sru|FHHHHJ|32445rcvhggb|32445rcvhggb|	
|tvbffg@gmail.com|Mr|rchg|tdch3545|354ccxgf|354ccxgf|
|tvsrudcg@gmail.com|Mrs|rchgr|tdch3tu|354ccxtu|354ccxtu|