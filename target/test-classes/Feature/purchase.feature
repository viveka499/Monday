Feature:Toypurchase
@purchase
Scenario: Purchase a toy
Given I open guru99 website
When user enters valid data details on the page
| Fields   |  values    |
| Quantity     |  2         | 
| card_nmuber  |  7493037578241902 |
| month        |  02         |
| year         |  2022      |
| cvv_code     |  989       |
Then payment should be done