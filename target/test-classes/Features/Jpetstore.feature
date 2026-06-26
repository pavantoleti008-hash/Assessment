Feature: Jpet store check out
Scenario Outline: Sign in and do checkout
Given user is on jpet store sign in page
When user enters valid <username> and <password>
Then user should login successfully
Then user should select category
Then user should select breed
Then user select add to cart
Then user should procees to check out
Then user should continue and confirm the order
Examples:
|username|password|
|pavan77|pavan123|