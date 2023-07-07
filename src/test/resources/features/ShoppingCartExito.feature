Feature: Add products to a shopping car
  As a user that want to purchase products from Exito Shopping page.
  I want to choose different products and add them to the shopping cart.

  Scenario Outline: Select products from a category and subcategory and add them to the shopping car.
    Given the user is in the Exito shopping page.
    When the user select a category "<Category>" and a subcategory "<Subcategory>".
    And adds five random products with an aleatory quantity between 1-10 products.
    And add the email "<Email>" to complete the purchase.
    Then the information of the products in the shopping have to be the same as the selected products
    Examples:
    | Category    | Subcategory  | Email                |
    | Dormitorio  | Cabeceros    | jardilac91@gmail.com |

